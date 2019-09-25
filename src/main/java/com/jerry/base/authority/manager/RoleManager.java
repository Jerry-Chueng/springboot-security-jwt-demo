package com.jerry.base.authority.manager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jerry.base.authority.dao.RoleMapper;
import com.jerry.base.authority.entity.Role;
import com.jerry.base.common.entity.PageResult;
import com.jerry.base.authority.vo.QueryVO;
import lombok.RequiredArgsConstructor;
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
public class RoleManager {

    private final RoleMapper roleMapper;

    public PageResult findAll(QueryVO vo){
        PageInfo<Role> pageInfo = PageHelper.startPage(vo.getPageNum(), vo.getPageSize()).doSelectPageInfo(()->roleMapper.findAll(vo));
        return new PageResult(pageInfo.getTotal(), pageInfo.getList(), vo.getPageNum(), vo.getPageSize());
    }

    public Role findById(Long id){
        return roleMapper.findById(id);
    }

    public Role findByName(String roleName){
        return roleMapper.findByName(roleName);
    }

    public int save(Role role){
        return roleMapper.save(role);
    }

    public int update(Role role){
        role.setModifyTime(new Date());
        return roleMapper.updateById(role);
    }

    @Transactional
    public int delete(List<Long> ids){
        roleMapper.deleteRelationshipRoleWithPrivilege(ids);
        roleMapper.deleteRelationshipRoleWithUser(ids);
        return roleMapper.deleteById(ids);
    }
}
