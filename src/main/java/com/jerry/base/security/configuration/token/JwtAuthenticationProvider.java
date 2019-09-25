package com.jerry.base.security.configuration.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jerry.base.security.configuration.token.JwtAuthenticationToken;
import com.jerry.base.security.service.AuthUserDetail;
import com.jerry.base.security.service.AuthUserDetailService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.NonceExpiredException;

import java.util.Calendar;

/**
 * jwt token验证
 * @author Jerry
 */
public class JwtAuthenticationProvider implements AuthenticationProvider {

	private AuthUserDetailService userService;

	public JwtAuthenticationProvider(AuthUserDetailService userService) {
		this.userService = userService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		DecodedJWT jwt = ((JwtAuthenticationToken)authentication).getToken();
		if(jwt.getExpiresAt().before(Calendar.getInstance().getTime())){
			throw new NonceExpiredException("token expires");
		}
		String username = jwt.getSubject();
		AuthUserDetail authUserDetail = (AuthUserDetail) userService.loadUserByUsername(username);
		if(authUserDetail == null || authUserDetail.getPassword()==null){
			throw new NonceExpiredException("token expires");
		}
		String tokenSalt = authUserDetail.getUser().getTokenSalt();
		try {
            Algorithm algorithm = Algorithm.HMAC256(tokenSalt);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withSubject(username)
                    .build();
            verifier.verify(jwt.getToken());
        } catch (Exception e) {
            throw new BadCredentialsException("token verify fail", e);
        }
		//成功后返回认证信息，filter会将认证信息放入SecurityContext
		JwtAuthenticationToken token = new JwtAuthenticationToken(authUserDetail, jwt, authUserDetail.getAuthorities());
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.isAssignableFrom(JwtAuthenticationToken.class);
	}

}
