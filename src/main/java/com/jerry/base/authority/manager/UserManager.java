package com.jerry.base.authority.manager;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jerry.base.authority.dao.UserMapper;
import com.jerry.base.authority.entity.User;
import com.jerry.base.common.entity.PageResult;
import com.jerry.base.common.entity.Response;
import com.jerry.base.authority.vo.QueryVO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
        PageInfo<User> pageInfo = PageHelper.startPage(vo.getPageNum(), vo.getPageSize()).doSelectPageInfo(()->userMapper.findAll(vo));
        return new PageResult(pageInfo.getTotal(), pageInfo.getList(), vo.getPageNum(), vo.getPageSize());
    }

    public User findById(Long id){
        return userMapper.findById(id);
    }

    public User findByUsername(String username){
        return userMapper.findByUsername(username);
    }

    @Transactional
    public void saveRelationshipWithRole(JSONObject obj){
        List<Long> list = obj.getJSONArray("userIds").toJavaList(Long.class);
        userMapper.deleteRelationshipUserWithRole(list);
        userMapper.saveRelationshipWithRole(obj);
    }

    public int save(User user){
        //密码加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return userMapper.save(user);
    }

    public int update(User user){
        user.setModifyTime(new Date());
        return userMapper.updateById(user);
    }

    public int updateUserTokenSalt(Long id,String tokenSalt){
        return userMapper.updateUserTokenSalt(id,tokenSalt);
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

    @Transactional
    public int delete(List<Long> ids) {
        userMapper.deleteRelationshipUserWithRole(ids);
        return userMapper.deleteById(ids);
    }
}
