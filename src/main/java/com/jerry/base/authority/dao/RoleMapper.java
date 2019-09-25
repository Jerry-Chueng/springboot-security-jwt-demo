package com.jerry.base.authority.dao;

import com.jerry.base.authority.entity.Role;
import com.jerry.base.authority.vo.QueryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by on 2019/8/27 21:19
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: demo
 */
public interface RoleMapper {

    int deleteById(@Param("ids") List<Long> ids);

    int deleteRelationshipRoleWithUser(@Param("ids") List<Long> ids);

    int deleteRelationshipRoleWithPrivilege(@Param("ids") List<Long> ids);

    int save(Role record);

    int updateById(Role record);

    Role findById(Long id);

    Role findByName(String name);

    List<Role> findAll(QueryVO vo);
}
