package com.jerry.base.common.controller;

import com.jerry.base.common.entity.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by on 2019-09-03 23:55
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: demo
 */
@Slf4j
public class BaseController {

    @ExceptionHandler
    public Response handleException(Exception ex){
        log.error("{}",ex);
        return Response.fail("操作错误", ex.getMessage());
    }
}
