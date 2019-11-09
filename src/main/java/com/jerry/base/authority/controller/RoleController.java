package com.jerry.base.authority.controller;

import com.jerry.base.authority.entity.Role;
import com.jerry.base.common.controller.BaseController;
import com.jerry.base.common.entity.PageResult;
import com.jerry.base.common.entity.Response;
import com.jerry.base.authority.manager.RoleManager;
import com.jerry.base.authority.dto.QueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by on 2019-08-18 12:57
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: demo
 */
@Api(value = "角色操作",tags = "角色对象")
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth/role")
public class RoleController extends BaseController {

    private final RoleManager roleManager;

    @ApiOperation(value = "获取角色List",notes = "获取角色List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword",value = "keyword",required = false,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "currentPage",value = "currentPage",required = true,defaultValue = "1",paramType = "query",dataType = "Long"),
            @ApiImplicitParam(name = "pageSize",value = "pageSize",required = true,defaultValue = "20",paramType = "query",dataType = "Long")
    })
    @GetMapping
    public Response list(String keyword,Integer currentPage,Integer pageSize){
        QueryVO vo = new QueryVO(keyword, currentPage, pageSize);
        PageResult pageResult = roleManager.findAll(vo);
        return new Response<>(pageResult);
    }

    @ApiOperation(value = "根据ID获取角色",notes = "根据ID获取角色")
    @GetMapping("/{id}")
    public Response get(@PathVariable("id")Long id){
        Role role = roleManager.findById(id);
        return new Response<>(role);
    }

    @ApiOperation(value = "保存角色",notes = "保存角色")
    @PostMapping
    public Response save(@RequestBody Role role) {
        Role r = roleManager.findByName(role.getName());
        if (r != null) {
            return Response.fail("角色名已经存在");
        }
        return Response.ok(roleManager.save(role));
    }

    @ApiOperation(value = "更新角色",notes = "更新角色")
    @PutMapping
    public Response update(@RequestBody Role role) {
        Role r = roleManager.findByName(role.getName());
        if (r != null && r.getId() != role.getId()) {
            return Response.fail("角色名已经存在");
        }
        return Response.ok(roleManager.update(role));
    }

    @ApiOperation(value = "删除角色",notes = "支持删除多角色")
    @DeleteMapping
    public Response delete(@RequestBody List<Long> ids) {
        return Response.ok(roleManager.delete(ids));
    }
}
