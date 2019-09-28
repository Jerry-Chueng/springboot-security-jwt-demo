package com.jerry.base.security.configuration;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.jerry.base.common.entity.Response;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.www.NonceExpiredException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
public class AuthFailureHandler implements AuthenticationFailureHandler, AccessDeniedHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		@Cleanup PrintWriter out = response.getWriter();
		if (exception instanceof BadCredentialsException) {
			out.write(new Response<>(null,HttpStatus.UNAUTHORIZED.value(),exception.getMessage()).toString());
		}else if(exception instanceof NonceExpiredException) {
			out.write(new Response<>(null,HttpStatus.UNAUTHORIZED.value(),exception.getMessage()).toString());
		}else {
			out.write(new Response<>(null,HttpStatus.UNAUTHORIZED.value(),exception.getMessage()).toString());
		}
	}

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		response.setStatus(HttpStatus.FORBIDDEN.value());
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		@Cleanup PrintWriter out = response.getWriter();
		out.write(new Response<>(null,HttpStatus.FORBIDDEN.value(),"权限不足，请联系管理员").toString());
	}
}
