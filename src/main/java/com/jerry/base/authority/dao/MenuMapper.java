package com.jerry.base.authority.dao;

import com.jerry.base.authority.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by on 2019/8/27 20:11
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: demo
 */
public interface MenuMapper {
    int deleteById(@Param("ids") List<Long> ids);

    int deleteRelationshipPrivilegeWithRole(@Param("ids") List<Long> ids);

    int deleteRoleRelationship(long roleId);

    int save(Menu record);

    int saveRelationshipWithRole(@Param("menuIds") List<Long> menuIds, @Param("roleId") long roleId);

    int update(Menu record);

    Menu findById(Long id);

    Menu findByName(String menuName);

    Menu findByPath(String path);

    List<Menu> list(@Param("ids") List<Long> ids, @Param("keyword") String keyword);

    List<Menu> getMenuListWithoutSubList();
}
