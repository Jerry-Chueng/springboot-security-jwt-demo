package com.jerry.base.authority.controller;

import com.jerry.base.authority.entity.Menu;
import com.jerry.base.common.controller.BaseController;
import com.jerry.base.common.entity.Response;
import com.jerry.base.authority.manager.MenuManager;
import io.swagger.annotations.Api;
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
@Api(value = "菜单操作", tags = "菜单对象")
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/menu")
public class MenuController extends BaseController {

    private final MenuManager menuManager;

    @ApiOperation(value = "获取菜单List", notes = "获取菜单List")
    @PostMapping("/list")
    public Response list(@RequestBody(required = false) List<Long> ids) {
        List<Menu> list = menuManager.getMenuList(ids);
        return new Response<>(list);
    }

    @ApiOperation(value = "保存菜单", notes = "保存菜单")
    @PostMapping("/save")
    public Response save(@RequestBody Menu menu) {
        Menu u = menuManager.findByName(menu.getName());
        if (u != null) {
            return Response.fail("菜单名已经存在");
        }
        return Response.ok(menuManager.save(menu));
    }

    @ApiOperation(value = "更新菜单", notes = "更新菜单")
    @PutMapping("/update")
    public Response update(@RequestBody Menu menu) {
        Menu u = menuManager.findByName(menu.getName());
        if (u != null) {
            return Response.fail("菜单名已经存在");
        }
        return Response.ok(menuManager.update(menu));
    }

    @ApiOperation(value = "删除菜单", notes = "支持删除多菜单")
    @DeleteMapping("/delete")
    public Response delete(@RequestBody List<Long> ids) {
        return Response.ok(menuManager.delete(ids));
    }

    @ApiOperation(value = "添加关联角色", notes = "添加关联角色")
    @PostMapping("/relateRole")
    public Response relateRole(@RequestParam Integer menuId,@RequestParam Integer roleId) {
        return Response.ok(menuManager.saveRelationshipWithRole(menuId, roleId));
    }

    @ApiOperation(value = "删除关联角色", notes = "删除关联角色")
    @DeleteMapping("/deleteRoleRelationship")
    public Response deleteRoleRelationship(@RequestParam Integer menuId,@RequestParam Integer roleId) {
        return Response.ok(menuManager.deleteRoleRelationship(menuId,roleId));
    }
}
