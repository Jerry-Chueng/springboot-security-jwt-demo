package com.jerry.base.security.configuration;

import com.jerry.base.security.service.PrivilegeService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
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
public class PrivilegeInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return SecurityConfig.createList("ROLE_ANONYMOUS");
        }

        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        int firstQuestionMarkIndex = requestUrl.indexOf("?");
        if (firstQuestionMarkIndex != -1) {
            requestUrl = requestUrl.substring(0, firstQuestionMarkIndex);
        }

        List<ConfigAttribute> configAttributes = PrivilegeService.getPrivilegeMeta(requestUrl);

        if (configAttributes == null || configAttributes.size() == 0) {
            return SecurityConfig.createList("ROLE_ANONYMOUS");
        }

        return configAttributes;

//        if (configAttributes == null) {
//            return SecurityConfig.createList();
//        } else if (menu != null && menu.getRoles().size() == 0) {
//            throw new AccessDeniedException("无权限访问");
//        }
//        Set<Role> roles = menu.getRoles();
//        List<String> roleNameList = roles.stream().map(role -> role.getName()).collect(Collectors.toList());
//        return SecurityConfig.createList(roleNameList.toArray(new String[roleNameList.size()]));
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
