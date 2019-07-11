package com.soft.recognition.garbage.controller;

import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/garbage")
public class GarbageController {
//    设置APPID/AK/SK
    public static final String APP_ID = "16780572";
    public static final String API_KEY = "u8fyLpHcmHnag8wkT9jXG42X";
    public static final String SECRET_KEY = "kQ57U1LwyD9QGQnPxXwlyGmjT5KF1HdK";

    public static void main(String[] args) {
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
//        String path = "/Users/han-shy/Downloads/lu.jpeg";
//        JSONObject res = client.objectDetect(path, new HashMap<String, String>());
//        System.out.println(res.toString(2));

        GarbageController con = new GarbageController();
        con.animal(client);
    }

    public void animal(AipImageClassify client){
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("top_num", "3");
        options.put("baike_num", "5");

        // 参数为本地路径
//        String image = "/Users/han-shy/Downloads/lu.jpeg";
//        JSONObject res = client.animalDetect(image, options);
//        System.out.println(res.toString(2));

        // 参数为二进制数组
        byte[] file = readFile("/Users/han-shy/Downloads/lu.jpeg");
        JSONObject res2 = client.animalDetect(file, options);
        System.out.println(res2.toString(2));
    }


    public static byte[]  readFile(String path){
        byte[] fileByte = null;
        try {
            File file = new File(path);
            fileByte = Files.readAllBytes(file.toPath());

        }catch (IOException e){
            e.printStackTrace();
        }
        return fileByte;

    }
}
