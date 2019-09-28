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

    public Menu(long id, long parentId, String name,String title, String path, int type, String icon, int order) {
        this.setId(id);
        this.parentId = parentId;
        this.title = title;
        this.name = name;
        this.path = path;
        this.type = type;
        this.icon = icon;
        this.order = order;
    }

    @ApiModelProperty(value = "parentId")
    private long parentId;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "title")
    private String title;

    /**
     * path
     */
    @ApiModelProperty(value = "path")
    private String path;

    /**
     * 约定 1:菜单，2:按钮
     */
    @ApiModelProperty(value = "type")
    private int type;

    @ApiModelProperty(value = "icon")
    private String icon;

    @ApiModelProperty(value = "order")
    private int order;

    private Set<Role> roles;

    private List<Menu> children;
}
