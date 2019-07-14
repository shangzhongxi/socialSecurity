package com.soft.recognition.garbage.controller;


import com.baidu.aip.imageclassify.AipImageClassify;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

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
//        String s = GarbageController.ImgToBase64("/Users/han-shy/Downloads/lu.jpeg");
//        System.out.println(s);
    }

    public void animal(AipImageClassify client){
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
//        options.put("top_num", "3");
        options.put("baike_num", "5");

        // 参数为本地路径
//        String image = "/Users/han-shy/Downloads/lu.jpeg";
//        JSONObject res = client.advancedGeneral(image, options);
//        System.out.println(res.toString(2));

        // 参数为二进制数组
        byte[] file = readFile("/Users/han-shy/Downloads/lu.jpeg");
        for (int i = 0;i<file.length;i++){
            System.out.print(file[i]);
        }
        JSONObject res2 = client.advancedGeneral(file, options);
        System.out.println(res2.toString(2));
//
//        String s = GarbageController.GetImageStr("/Users/han-shy/Downloads/lu.jpeg");
//        System.out.println(s);
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

    /**
     * 接收base64请求，转换成byte，失败。
     * 原因：从base64转来的byte与直接将文件转换成的byte不一样。导致baidu接口报错image format error
     * @param img
     * @return
     */
    public JSONObject sendMessage(String img){

        BASE64Decoder decoder = new BASE64Decoder();
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("baike_num", "5");

        JSONObject json = new JSONObject();

        img = img.split(",")[1];

        try {
             // Base64解码
             byte[] b = decoder.decodeBuffer(img);
             for (int i = 0; i < b.length; ++i) {
//                     if (b[i] < 0) {// 调整异常数据
//                             b[i] += 256;
//                         }
                 System.out.print(b[i]);
                 }
            json = client.advancedGeneral(b,options);
        }catch (IOException e){
            e.printStackTrace();
        }

        return json;
    }

    public static String GetImageStr(String imgPath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
                 String imgFile = imgPath;// 待处理的图片
                 InputStream in = null;
                 byte[] data = null;
                 String encode = null; // 返回Base64编码过的字节数组字符串
                 // 对字节数组Base64编码
                 BASE64Encoder encoder = new BASE64Encoder();
                 try {
                         // 读取图片字节数组
                         in = new FileInputStream(imgFile);
                         data = new byte[in.available()];
                         in.read(data);
                         encode = encoder.encode(data);
                     } catch (IOException e) {
                         e.printStackTrace();
                     } finally {
                         try {
                                 in.close();
                             } catch (IOException e) {
                                 // TODO Auto-generated catch block
                                 e.printStackTrace();
                }
                     }
                 return encode;
            }

    /**
     * 接收图片文件接口
     * @param file
     * @return
     */
    @RequestMapping(value = "/imgDiscern",method = RequestMethod.POST)
    @ResponseBody
    public Map<String ,Object> imgDiscern(MultipartFile file)  {
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("baike_num", "5");
        byte[] bytes = null;
        try {
           bytes = file.getBytes();
        }catch (IOException e){
            e.printStackTrace();
        }
        JSONObject res2 = client.advancedGeneral(bytes, options);
        Map<String,Object> map = GarbageController.toMap(res2);
        return  map;

    }


    /**
     * jsonObject 转 Map
     * @param object
     * @return
     */
    private static Map<String, Object> toMap(JSONObject object) {
        Map<String, Object> map = new HashMap<String, Object>();
        Object value;
        String key;
        for (Iterator<?> it = object.keys(); it.hasNext() ; ) {
            key = (String) it.next();
            if (object.isNull(key)) {
                map.put(key, null);
            } else {
                try {
                    value = object.get(key);
                    if (value instanceof JSONArray) {
                        value = toList((JSONArray) value);
                    } else if (value instanceof JSONObject) {
                        value = toMap((JSONObject) value);
                    }
                    map.put(key, value);
                } catch (JSONException e) {
                }
            }
        }
        return map;
    }

    /**
     * JsonArray 转 List
     * @param array
     * @return
     */
    private static List toList(JSONArray array) {
        List list = new ArrayList();
        Object value;
        for (int i = 0; i < array.length(); i++) {
            try {
                value = array.get(i);
                if (value instanceof JSONArray) {
                    value = toList((JSONArray) value);
                } else if (value instanceof JSONObject) {
                    value = toMap((JSONObject) value);
                }
                list.add(value);
            } catch (JSONException e) {
            }
        }
        return list;
    }



}
