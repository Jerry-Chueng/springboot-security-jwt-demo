/*
 * Copyright 2002-2016 Guangdong Etone Technology Co.,Ltd.
 * All rights reserved.
 */
package com.jerry.utils.http;

/**
 * 公用常量类
 */
public abstract class Constants {

    //:~ CAOP 协议请求参共享参数
    // 应用标识
    public static final String APP_ID = "app_id";
    // 响应格式 json,xml
    public static final String FORMAT = "format";
    // 方法 GET,POST
    public static final String METHOD = "method";
    // 时间截
    public static final String TIMESTAMP = "timestamp";
    // 签名
    public static final String SIGNATURE = "sign";
    // 签名方法 hmac,md5
    public static final String SIGNATURE_METHOD = "sign_method";
    // 随机数
    public static final String SIGNATURE_NONCE = "nonce";
    // 合作商标识
    public static final String PARTNER_ID = "partner_id";
    // 访问令牌
    public static final String ACCESS_TOKEN = "access_token";
    // 是否采用精简JSON返回格式，仅当format=json时有效，默认值为：false
    public static final String SIMPLIFY = "simplify";
    // APP之间调用时使用
    public static final String TARGET_APP_KEY = "target_app_key";
    // 协议版本 (不保存在数据库中，硬编码)
    public static final String VERSION = "v";

    //:~ CAOP 协议响应参共享参数
    public static final String ERROR_RESPONSE = "error_response";
    public static final String ERROR_CODE = "code";
    public static final String ERROR_MSG = "msg";
    public static final String ERROR_SUB_CODE = "sub_code";
    public static final String ERROR_SUB_MSG = "sub_msg";

    /**
     * CAOP 默认时间格式
     **/
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * CAOP Date 默认时区
     **/
    public static final String DATE_TIMEZONE = "GMT+8";

    /**
     * UTF-8字符集
     **/
    public static final String CHARSET_UTF8 = "UTF-8";

    /**
     * GBK字符集
     **/
    public static final String CHARSET_GBK = "GBK";

    /**
     * CAOP JSON 应格式
     */
    public static final String FORMAT_JSON = "json";
    /**
     * CAOP XML 应格式
     */
    public static final String FORMAT_XML = "xml";

    /**
     * MD5签名方式
     */
    public static final String SIGN_METHOD_MD5 = "md5";
    /**
     * HMAC签名方式
     */
    public static final String SIGN_METHOD_HMAC = "hmac";

    /**
     * SDK版本号
     */
    public static final String SDK_VERSION = "caop-sdk-java-20160401";

    /**
     * 异步多活SDK版本号
     */
    public static final String SDK_VERSION_CLUSTER = "caop-sdk-java-cluster-20160401";

    /**
     * 响应编码
     */
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_ENCODING_GZIP = "gzip";

    /**
     * 默认媒体类型
     **/
    public static final String MIME_TYPE_DEFAULT = "application/octet-stream";

    /**
     * 默认流式读取缓冲区大小
     **/
    public static final int READ_BUFFER_SIZE = 1024 * 4;

    public static final String CAOP_REF_KEY = "caop_ref_key";
    public static final String CAOP_SUB_CODE = "caop_sub_code";
    public static final String CAOP_SUB_MSG = "caop_sub_msg";
}
