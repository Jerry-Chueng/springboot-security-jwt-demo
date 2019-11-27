package com.jerry.base.security.service;

import com.jerry.base.authority.entity.Menu;
import com.jerry.base.authority.entity.Role;
import com.jerry.base.authority.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by on 2019-07-03 23:58
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: demo
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserDetail implements UserDetails {

    private User user;

    private List<Menu> menus;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        if (!CollectionUtils.isEmpty(menus)) {
            for (Menu menu : menus) {
                if (!StringUtils.isEmpty(menu.getPermission())) {
                    authorities.add(new SimpleGrantedAuthority(menu.getPermission()));
                }
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
