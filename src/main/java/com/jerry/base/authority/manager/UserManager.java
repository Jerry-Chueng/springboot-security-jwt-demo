package com.jerry.base.authority.manager;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jerry.base.authority.dao.UserMapper;
import com.jerry.base.authority.entity.User;
import com.jerry.base.common.entity.BaseEntity;
import com.jerry.base.common.entity.PageResult;
import com.jerry.base.common.entity.Response;
import com.jerry.base.authority.dto.QueryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by on 2019-08-18 14:22
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: demo
 */
@Service
@RequiredArgsConstructor
public class UserManager {

    private final UserMapper userMapper;

    public PageResult findAll(QueryVO vo){
        PageInfo<User> pageInfo = PageHelper.startPage(vo.getCurrentPage(), vo.getPageSize()).doSelectPageInfo(()->userMapper.findAll(vo));
        return new PageResult(pageInfo.getTotal(), pageInfo.getList(), vo.getCurrentPage(), vo.getPageSize());
    }

    public User findById(Long id){
        return userMapper.findById(id);
    }

    public User findByUsername(String username){
        return userMapper.findByUsername(username);
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveRelationshipWithRole(JSONObject obj){
        List<Long> list = obj.getJSONArray("userIds").toJavaList(Long.class);
        userMapper.deleteRelationshipUserWithRole(list);
        if (obj.getJSONArray("roleIds").size() > 0) {
            userMapper.saveRelationshipWithRole(obj);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public long save(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userMapper.save(user);
        handleSaveRelationshipWithRole(user,user.getId());
        return user.getId();
    }

    public long update(User user){
        int count = userMapper.updateById(user);
        handleSaveRelationshipWithRole(user,user.getId());
        return count;
    }

    public void updateUserTokenSalt(Long id,String tokenSalt){
        userMapper.updateUserTokenSalt(id,tokenSalt);
    }

    public Response updateUserPassword(Long id, String oldPwd, String newPwd) {
        User user = findById(id);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (user != null && encoder.matches(oldPwd, user.getPassword())) {
            userMapper.updateUserPassword(id, encoder.encode(newPwd));
            return Response.ok();
        }else{
            return Response.fail("用户不存在或密码错误");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public int delete(List<Long> ids) {
        userMapper.deleteRelationshipUserWithRole(ids);
        return userMapper.deleteById(ids);
    }

    private void handleSaveRelationshipWithRole(User user,long id){
        JSONObject obj = new JSONObject();
        obj.put("userIds", Collections.singletonList(id));
        obj.put("roleIds", user.getRoles().stream().map(BaseEntity::getId).collect(Collectors.toList()));
        saveRelationshipWithRole(obj);
    }
}
