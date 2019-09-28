package com.jerry.base.authority.controller;

import com.alibaba.fastjson.JSONObject;
import com.jerry.base.authority.entity.User;
import com.jerry.base.common.controller.BaseController;
import com.jerry.base.common.entity.PageResult;
import com.jerry.base.common.entity.Response;
import com.jerry.base.authority.manager.UserManager;
import com.jerry.base.authority.dto.QueryVO;
import io.swagger.annotations.*;
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
@Api(tags = "用户操作")
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/user")
public class UserController extends BaseController {

    private final UserManager userManager;

    @ApiOperation(value = "获取用户List",notes = "获取用户List")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "keyword",value = "keyword",required = false,paramType = "query",dataType = "String"),
        @ApiImplicitParam(name = "pageNum",value = "pageNum",required = true,paramType = "query",dataType = "Long"),
        @ApiImplicitParam(name = "pageSize",value = "pageSize",required = true,paramType = "query",dataType = "Long")
    })
    @GetMapping("/list")
    public Response list(String keyword,Integer pageNum,Integer pageSize){
        QueryVO vo = new QueryVO(keyword, pageNum, pageSize);
        PageResult pageResult = userManager.findAll(vo);
        return new Response<>(pageResult);
    }

    @ApiOperation(value = "保存用户",notes = "保存用户")
    @PostMapping("/save")
    public Response save(@RequestBody User user) {
        User u = userManager.findByUsername(user.getUsername());
        if (u != null) {
            return Response.fail("用户名已经存在");
        }
        return Response.ok(userManager.save(user));
    }

    @ApiOperation(value = "更新用户",notes = "更新用户,用户名不允许修改")
    @PutMapping("/update")
    public Response update(@RequestBody User user) {
        return Response.ok(userManager.update(user));
    }

    @ApiOperation(value = "删除用户",notes = "支持删除多用户")
    @DeleteMapping("/delete")
    public Response delete(@RequestBody List<Long> ids) {
        return Response.ok(userManager.delete(ids));
    }

    @ApiOperation(value = "关联角色",notes = "支持多角色关联")
    @PostMapping("/relateRole")
    public Response relateRole(@RequestBody @ApiParam(value = "userIds,roleIds") JSONObject obj) {
        userManager.saveRelationshipWithRole(obj);
        return Response.ok();
    }

    @ApiOperation(value = "修改密码",notes = "修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id",required = true,paramType = "query",dataType = "Long"),
            @ApiImplicitParam(name = "oldPwd",value = "oldPwd",required = true,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "newPwd",value = "newPwd",required = true,paramType = "query",dataType = "String")
    })
    @PutMapping("/updateUserPassword")
    public Response updateUserPassword(Long id,String oldPwd,String newPwd) {
        return userManager.updateUserPassword(id,oldPwd,newPwd);
    }
}
