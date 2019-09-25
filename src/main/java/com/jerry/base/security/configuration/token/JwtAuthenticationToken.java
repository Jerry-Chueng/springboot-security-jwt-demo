package com.jerry.base.security.configuration.token;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.jerry.base.security.service.AuthUserDetail;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

	private AuthUserDetail principal;
	private String credentials;
	private DecodedJWT token;

	public JwtAuthenticationToken(DecodedJWT token) {
		super(Collections.emptyList());
		this.token = token;
	}

	public JwtAuthenticationToken(AuthUserDetail principal, DecodedJWT token, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
		this.token = token;
	}

	@Override
	public void setDetails(Object details) {
		super.setDetails(details);
		this.setAuthenticated(true);
	}

	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

	public DecodedJWT getToken() {
		return token;
	}

}
