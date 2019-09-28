package com.jerry.base.security.service;

import com.jerry.base.authority.dao.MenuMapper;
import com.jerry.base.authority.entity.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 启动项目即加载所有权限，方便鉴权
 *
 * Created by on 2019-07-14 16:32
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: spring-security-demo
 */
@Component
@Order(0)
@RequiredArgsConstructor
public class PrivilegeService implements CommandLineRunner {

    private static Map<String, List<ConfigAttribute>> PRIVILEGE_META_SOURCE = new HashMap<>();

    private final MenuMapper privilegeMapper;

    @Override
    public void run(String... args) throws Exception {
        List<Menu> privilegeList = privilegeMapper.getMenuListWithoutSubList();
        for (Menu privilege : privilegeList) {
            PRIVILEGE_META_SOURCE.put(privilege.getPath(),
                    privilege.getRoles().stream()
                            .map(role -> new SecurityConfig(role.getName()))
                            .collect(Collectors.toList()));
        }
    }

    public static List<ConfigAttribute> getPrivilegeMeta(String path){
        List<Map.Entry<String,List<ConfigAttribute>>> list = PRIVILEGE_META_SOURCE.entrySet().stream()
                .filter(entry -> path.startsWith(entry.getKey()))
                .collect(Collectors.toList());
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0).getValue();
    }

    public static void updatePrivilegeMeta(String path,List<ConfigAttribute> configAttributes){
        PRIVILEGE_META_SOURCE.put(path, configAttributes);
    }

    public static void deletePrivilegeMeta(String path,List<ConfigAttribute> configAttributes){
        PRIVILEGE_META_SOURCE.put(path, configAttributes);
    }
}
