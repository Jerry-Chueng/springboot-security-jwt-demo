package com.jerry.base.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by on 2019-09-17 16:28
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: demo
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseEntity {

    @ApiModelProperty(value = "id")
    private long id;
    /**
     * createTime
     */
    @ApiModelProperty(value = "createTime",example = "2019-9-17 16:00:00")
    @JsonFormat(pattern = Constant.DATE_FORMAT)
    private Date createTime;

    /**
     * modifyTime
     */
    @ApiModelProperty(value = "modifyTime",example = "2019-9-17 16:00:00")
    @JsonFormat(pattern = Constant.DATE_FORMAT)
    private Date modifyTime;

    /**
     * remark
     */
    @ApiModelProperty(value = "remark")
    private String remark;

    @ApiModelProperty(value = "hide")
    private boolean isHide;
}
