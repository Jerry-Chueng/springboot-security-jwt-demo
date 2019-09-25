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

    int deleteRoleRelationship(int menuId, int roleId);

    int save(Menu record);

    int saveRelationshipWithRole(int menuId, int roleId);

    int updateByIdSelective(Menu record);

    int updateById(Menu record);

    Menu findById(Long id);

    Menu findByName(String menuName);

    Menu findByPath(String path);

    List<Menu> findAll();
}
