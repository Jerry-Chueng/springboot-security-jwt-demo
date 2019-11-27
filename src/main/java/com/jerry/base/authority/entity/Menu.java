package com.jerry.base.authority.entity;

import com.jerry.base.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by on 2019/8/27 20:11
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: demo
 */
@ApiModel(value = "Menu")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Menu extends BaseEntity {

    @ApiModelProperty(value = "parentId")
    private long parentId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "路径")
    private String path;

    @ApiModelProperty(value = "前端组件路径")
    private String component;

    @ApiModelProperty(value = "类型",notes = "约定 0:目录，1:菜单，2:按钮")
    private int type;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "排序")
    private int order;

    @ApiModelProperty(value = "权限标识")
    private String permission;

    private Set<Role> roles;

    private List<Menu> children;
}
