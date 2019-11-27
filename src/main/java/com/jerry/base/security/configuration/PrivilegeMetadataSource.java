package com.jerry.base.security.configuration;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * Created by on 2019-07-07 13:59
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: demo
 */
@Component
public class PrivilegeMetadataSource implements FilterInvocationSecurityMetadataSource {


    /**
     * FilterSecurityInterceptor会调用此方法，
     * 而FilterSecurityInterceptor在WebSecurityConfig中定义使用
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return SecurityConfig.createList("ROLE_ANONYMOUS");
        }

        List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();

        String[] list = authorities.stream().map(GrantedAuthority::getAuthority).toArray(String[]::new);

        return SecurityConfig.createList(list);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
