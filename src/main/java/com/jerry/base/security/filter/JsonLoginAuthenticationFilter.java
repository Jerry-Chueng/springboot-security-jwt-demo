package com.jerry.base.security.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jerry
 */
public class JsonLoginAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	public JsonLoginAuthenticationFilter() {
		//拦截url为 "/login" 的POST请求
		super(new AntPathRequestMatcher("/login", "POST"));
	}

	@Override
	public void afterPropertiesSet() {
		Assert.notNull(getAuthenticationManager(), "authenticationManager must be specified");
		Assert.notNull(getSuccessHandler(), "AuthenticationSuccessHandler must be specified");
		Assert.notNull(getFailureHandler(), "AuthenticationFailureHandler must be specified");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String username = request.getParameter("username"),
				password = request.getParameter("password");
		if(StringUtils.isEmpty(username)) {
			throw new UsernameNotFoundException("username is empty");
		}
		if(StringUtils.isEmpty(password)) {
			throw new BadCredentialsException("password is empty");
		}
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				username, password);

		return this.getAuthenticationManager().authenticate(authenticationToken);
	}
}
