package com.jerry.base.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * @author Jerry
 */
@Getter
@Setter
@AllArgsConstructor
public class PageResult {
    /**
     *查询结果总数
     */
    private Long total;
    /**
     *查询结果结合
     */
    private List list;
    /**
     *查询容量
     */
    private Integer pageSize;
    /**
     *查询页码
     */
    private Integer currentPage;
}
