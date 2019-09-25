package com.jerry.base.authority.entity;

import com.jerry.base.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by on 2019/8/24 15:15
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: demo
 */
@ApiModel(value = "User")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    /**
     * username
     */
    @ApiModelProperty(value = "username")
    private String username;

    /**
     * password
     */
    @ApiModelProperty(value = "password")
    private String password;

    /**
     * tokenSalt
     */
    @ApiModelProperty(value = "tokenSalt")
    private String tokenSalt;

    /**
     * age
     */
    @ApiModelProperty(value = "age")
    private Integer age;

    private Set<Role> roles;


}
