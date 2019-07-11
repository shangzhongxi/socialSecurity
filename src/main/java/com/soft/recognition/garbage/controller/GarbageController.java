package com.soft.recognition.garbage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/garbage")
public class GarbageController {
    //设置APPID/AK/SK
//    public static final String APP_ID = "你的 App ID";
//    public static final String API_KEY = "你的 Api Key";
//    public static final String SECRET_KEY = "你的 Secret Key";
//
//    public static void main(String[] args) {
//        // 初始化一个AipImageClassify
//        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
//
//        // 可选：设置网络连接参数
//        client.setConnectionTimeoutInMillis(2000);
//        client.setSocketTimeoutInMillis(60000);
//
//        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
//
//        // 调用接口
//        String path = "test.jpg";
//        JSONObject res = client.objectDetect(path, new HashMap<String, String>());
//        System.out.println(res.toString(2));
//
//    }
}
