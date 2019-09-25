package com.jerry.base.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @description:  分页返回前台对象
 * @author:Mr.Young
 * @date:2018/9/27
 */
@Getter
@Setter
@AllArgsConstructor
public class PageResult {
    private Long total;                 //查询结果总数
    private List list;                  //查询结果结合
    private Integer pageSize;           //查询容量
    private Integer pageNum;         //查询页码
}
