package com.jerry.base.security.configuration.token;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.jerry.base.security.service.AuthUserDetail;
import com.jerry.base.security.service.AuthUserDetailService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JwtRefreshSuccessHandler implements AuthenticationSuccessHandler {

	//刷新间隔55分钟
	private static final int tokenRefreshInterval = 60 * 55;

	private AuthUserDetailService authUserDetailService;

	public JwtRefreshSuccessHandler(AuthUserDetailService authUserDetailService) {
		this.authUserDetailService = authUserDetailService;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
		DecodedJWT jwt = ((JwtAuthenticationToken)authentication).getToken();
		boolean shouldRefresh = shouldTokenRefresh(jwt.getIssuedAt());
		if(shouldRefresh) {
			AuthUserDetail authUserDetail = (AuthUserDetail) authentication.getPrincipal();
            String newToken = authUserDetailService.createJwtToken(authUserDetail);
            response.setHeader("Authorization", newToken);
        }
	}

	protected boolean shouldTokenRefresh(Date issueAt){
        LocalDateTime issueTime = LocalDateTime.ofInstant(issueAt.toInstant(), ZoneId.systemDefault());
        return LocalDateTime.now().minusSeconds(tokenRefreshInterval).isAfter(issueTime);
    }

}
