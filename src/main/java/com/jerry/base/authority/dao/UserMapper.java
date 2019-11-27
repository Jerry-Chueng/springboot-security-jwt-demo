package com.jerry.base.authority.dao;

import com.alibaba.fastjson.JSONObject;
import com.jerry.base.authority.entity.User;
import com.jerry.base.authority.dto.QueryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by on 2019/8/24 15:15
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: demo
 */
public interface UserMapper {
    int deleteById(@Param("ids") List<Long> ids);

    int deleteRelationshipUserWithRole(@Param("ids") List<Long> ids);

    int save(User record);

    int saveRelationshipWithRole(@Param("obj") JSONObject obj);

    int updateUserPassword(@Param("id") Long id, @Param("newPwd") String newPwd);

    int update(User record);

    int updateUserTokenSalt(@Param("id") Long id, @Param("tokenSalt") String tokenSalt);

    User findById(Long id);

    User findByUsername(String username);

    List<User> findAll(QueryVO vo);
}
