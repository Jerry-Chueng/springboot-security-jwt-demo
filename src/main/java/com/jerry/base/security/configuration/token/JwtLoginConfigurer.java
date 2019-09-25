package com.jerry.base.security.configuration.token;

import com.jerry.base.security.configuration.AuthFailureHandler;
import com.jerry.base.security.filter.JwtAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;

public class JwtLoginConfigurer<T extends JwtLoginConfigurer<T, B>, B extends HttpSecurityBuilder<B>> extends AbstractHttpConfigurer<T, B> {

	private JwtAuthenticationFilter authFilter;

	public JwtLoginConfigurer() {
		this.authFilter = new JwtAuthenticationFilter();
	}

	@Override
	public void configure(B http) throws Exception {
		authFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
		//登录失败处理器
		authFilter.setAuthenticationFailureHandler(new AuthFailureHandler());
		//将filter放到logoutFilter之前
		JwtAuthenticationFilter filter = postProcess(authFilter);
		http.addFilterBefore(filter, LogoutFilter.class);
	}

	/**
	 * 设置匿名用户可访问url
	 * @param urls
	 * @return
	 */
	public JwtLoginConfigurer<T, B> permissiveRequestUrls(String ... urls){
		authFilter.setPermissiveUrl(urls);
		return this;
	}

	public JwtLoginConfigurer<T, B> tokenValidSuccessHandler(AuthenticationSuccessHandler successHandler){
		authFilter.setAuthenticationSuccessHandler(successHandler);
		return this;
	}

}
