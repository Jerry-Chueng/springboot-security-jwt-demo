package com.jerry.base.security.configuration;

import java.io.Serializable;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Jerry
 */
@Configuration
public class PrivilegeDecisionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        boolean accessable = false;
        if(authentication.getPrincipal().toString().compareToIgnoreCase("anonymousUser") != 0){
            String privilege = targetDomainObject + ":" + permission;
            for(GrantedAuthority authority : authentication.getAuthorities()){
                if(privilege.equals(authority.getAuthority())){
                    accessable = true;
                    break;
                }
            }
            return accessable;
        }
        return accessable;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
