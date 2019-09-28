package com.jerry.base.security.configuration;

import com.jerry.base.authority.manager.UserManager;
import com.jerry.base.security.configuration.json.JsonLoginConfigurer;
import com.jerry.base.security.configuration.json.JsonLoginSuccessHandler;
import com.jerry.base.security.configuration.token.JwtClearLogoutHandler;
import com.jerry.base.security.configuration.token.JwtLoginConfigurer;
import com.jerry.base.security.configuration.token.JwtRefreshSuccessHandler;
import com.jerry.base.security.filter.OptionsRequestFilter;
import com.jerry.base.security.configuration.token.JwtAuthenticationProvider;
import com.jerry.base.security.service.AuthUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.header.Header;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.profiles.active}")
    private String activeProfiles;

    @Autowired
    private UserManager userManager;

    @Autowired
    private PrivilegeInvocationSecurityMetadataSourceService privilegeInvocationSecurityMetadataSourceService;

    @Autowired
    private PrivilegeAccessDecisionManager privilegeAccessDecisionManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setSecurityMetadataSource(privilegeInvocationSecurityMetadataSourceService);
                        object.setAccessDecisionManager(privilegeAccessDecisionManager);
                        return object;
                    }
                })
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new AuthFailureHandler())
                .and()
                .csrf().disable()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).disable()
                .cors()
                .and()
                .headers().addHeaderWriter(new StaticHeadersWriter(Arrays.asList(
                    new Header("Access-control-Allow-Origin", "*"),
                    new Header("Access-Control-Expose-Headers", "Authorization"))))
                .and()
                .addFilterAfter(new OptionsRequestFilter(), CorsFilter.class)
                .apply(new JsonLoginConfigurer<>()).loginSuccessHandler(jsonLoginSuccessHandler())
                .and()
                .apply(new JwtLoginConfigurer<>()).tokenValidSuccessHandler(jwtRefreshSuccessHandler())
                .permissiveRequestUrls("/logout")
                .and()
                .logout()
                .permitAll()
//		        .logoutUrl("/logout")   //默认就是"/logout"
                .addLogoutHandler(tokenClearLogoutHandler())
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).disable();
    }

    /**
     * 在这里配置哪些页面不需要认证
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        if (activeProfiles.equals("dev")) {
//            web.ignoring().antMatchers("/**");
            web.ignoring().antMatchers("/error", "/favicon.ico", "/auth/menu/list",
                    "/static/**", "/**/*swagger*/**", "/csrf", "/v2/**", "/");
        }else{
            web.ignoring().antMatchers("/error", "/favicon.ico", "/auth/menu/list");
        }

    }

    /**
     * 定义认证用户信息获取来源，密码校验规则等
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //有以下几种形式，使用第3种
        //inMemoryAuthentication 从内存中获取
        //auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("user1").password(new BCryptPasswordEncoder().encode("123123")).roles("USER");
        auth.authenticationProvider(daoAuthenticationProvider())
                .authenticationProvider(jwtAuthenticationProvider());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean("jwtAuthenticationProvider")
    protected AuthenticationProvider jwtAuthenticationProvider() {
        return new JwtAuthenticationProvider(authUserDetailService());
    }

    /**
     * 登录账号密码校验
     * 如有需要可以继承DaoAuthenticationProvider，重写additionalAuthenticationChecks()，这里就是做密码比较的
     * @throws Exception
     */
    @Bean("daoAuthenticationProvider")
    protected AuthenticationProvider daoAuthenticationProvider() throws Exception {
        //这里会默认使用BCryptPasswordEncoder比对加密后的密码，注意要跟createUser时保持一致
        DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
        daoProvider.setUserDetailsService(userDetailsService());
        daoProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return daoProvider;
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return new AuthUserDetailService(userManager);
    }

    @Bean("authUserDetailService")
    protected AuthUserDetailService authUserDetailService() {
        return new AuthUserDetailService(userManager);
    }

    /**
     * 登录成功处理
     * @return
     */
    @Bean
    protected JsonLoginSuccessHandler jsonLoginSuccessHandler() {
        return new JsonLoginSuccessHandler(authUserDetailService());
    }

    /**
     * tokenValidSuccessHandler
     *
     * @return
     */
    @Bean
    protected JwtRefreshSuccessHandler jwtRefreshSuccessHandler() {
        return new JwtRefreshSuccessHandler(authUserDetailService());
    }

    @Bean
    protected JwtClearLogoutHandler tokenClearLogoutHandler() {
        return new JwtClearLogoutHandler(authUserDetailService());
    }

    @Bean
    protected CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "HEAD", "OPTION"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.addExposedHeader("Authorization");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
