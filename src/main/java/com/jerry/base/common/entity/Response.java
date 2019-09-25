package com.jerry.base.common.entity;


import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class Response<T> {

    public static final int SUCCESS = 0;

    public static final int FAIL = 2;

    private int code;

    private String message;

    private String description;

    private T content;


    /**
     * 默认code为0 成功
     */
    public Response() {
        this(null, SUCCESS, "成功");
    }

    /**
     * 默认code为0 成功
     */
    public Response(T content) {
        this(content, SUCCESS, "成功");
    }

    public Response(T content, int code, String message) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public Response(T content, int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.content = content;
        this.description = description;
    }

    public static Response ok() {
        return new Response();
    }

    public static <T> Response ok(T content) {
        return new Response<>(content);
    }

    public static <T> Response fail(T content){
        return new Response<>(content, FAIL, "失败");
    }

    public static <T> Response fail(T content,String msg){
        return new Response<>(content, FAIL, msg);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
