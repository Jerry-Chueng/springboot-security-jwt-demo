package com.jerry.utils.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by on 2019-09-05 21:55
 *
 * @Maintainance: jerryzshiyan@163.com
 * @author: Jerry
 * @Project: demo
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String url = "http://xxx";
        Map<String, String> params = new HashMap<String, String>();
        String res = WebKit.doPost(url, params, "utf-8", 600000, 600000);
        System.out.println(res);
    }
}
