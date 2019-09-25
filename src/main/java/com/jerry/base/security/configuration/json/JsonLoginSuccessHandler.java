package com.jerry.base.security.configuration.json;

import com.jerry.base.common.entity.Response;
import com.jerry.base.security.service.AuthUserDetail;
import com.jerry.base.security.service.AuthUserDetailService;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class JsonLoginSuccessHandler implements AuthenticationSuccessHandler {


	private AuthUserDetailService authUserDetailService;

	public JsonLoginSuccessHandler(AuthUserDetailService authUserDetailService) {
		this.authUserDetailService = authUserDetailService;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
		AuthUserDetail authUserDetail = (AuthUserDetail)authentication.getPrincipal();
		String token = authUserDetailService.createJwtToken(authUserDetail);
		response.setHeader("Authorization", token);
		response.setContentType("application/json;charset=utf-8");
		@Cleanup PrintWriter out = response.getWriter();
		out.write(new Response().toString());
	}

}
