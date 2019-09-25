package com.jerry.base.security.configuration.token;

import com.jerry.base.security.service.AuthUserDetailService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtClearLogoutHandler implements LogoutHandler {

	private AuthUserDetailService authUserDetailService;

	public JwtClearLogoutHandler(AuthUserDetailService authUserDetailService) {
		this.authUserDetailService = authUserDetailService;
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		clearToken(authentication);
	}

	protected void clearToken(Authentication authentication) {
		if (authentication == null) {
			return;
		}
		UserDetails user = (UserDetails)authentication.getPrincipal();
		if (user != null && user.getUsername() != null) {
			authUserDetailService.deleteUserLoginInfo(user.getUsername());
		}
	}

}
