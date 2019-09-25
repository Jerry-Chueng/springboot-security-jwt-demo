package com.jerry.modules.test.vo;

import com.jerry.base.authority.vo.QueryVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by on 2019-08-18 11:00
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: demo
 */
@Getter
@Setter
@ApiModel(value = "测试VO",description = "测试TestVO")
public class TestVO extends QueryVO {

    @ApiModelProperty(value = "测试id")
    private int id;

    @ApiModelProperty(value = "测试用户名")
    private String name;
}
