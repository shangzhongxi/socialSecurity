package com.soft.social.login.controller;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.soft.social.common.*;
import com.soft.social.user.model.UserEtity;
import com.soft.social.login.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    private String logtitle = "登陆 |#";

    @Autowired
    private LoginService service;

    @ResponseBody
    @PostMapping(value = "/smsSend" )
    @ApiOperation(value = "发送验证码",notes = "发送验证码")
    public BaseResponseSingle verifyCodeResult(@ModelAttribute UserEtity user) {
        String number = user.getTelephoneNum();
        // 短信应用SDK AppID
        int appid = 1400181821; // 1400开头

        // 短信应用SDK AppKey
        String appkey = "e27c19d8f8205b84b3d325abf9a2c0ff";

        // 需要发送短信的手机号码
        //String phoneNumbers = {"21212313123", "12345678902", "12345678903"};

        // 短信模板ID，需要在短信应用中申请
        int templateId = 272707; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
        //templateId7839对应的内容是"您的验证码是: {1}"
        // 签名
        String smsSign = "情非所以"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
        BaseResponseSingle<String> data = new BaseResponseSingle<>();
        String varifyCode = String.valueOf((int) ((Math.random() * 9 + 1) * 1000)); //验证码
        try {
            String[] params = {varifyCode};//数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", number,
                    templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.println(result);

            logger.debug("验证码获取成功 |#" + "验证码是：" + varifyCode + "|#");

            service.insertVerifyCode(number,varifyCode);
            logger.debug("验证码插入成功 |#");

            data.setData("TRUE");
            data.setMessage("短信验证码发送成功");
            data.setSuccess("1");
            data.setHttpStatus(HttpStatus.gethttpStatus());

        } catch (Exception e) {
            // HTTP响应码错误
            e.printStackTrace();
            data.setData("FALSE");
            data.setMessage("短信验证码发送失败");
            data.setSuccess("-1");
            data.setHttpStatus(HttpStatus.gethttpStatus());
        }
        return data;
    }


    @ResponseBody
    @PostMapping(value = "/login")
    @ApiOperation(value = "登陆",notes = "登陆")
    public BaseResponseSingle login(@ModelAttribute UserEtity user) throws Exception{
        BaseResponseSingle<HashMap<String,String>> data = new BaseResponseSingle<>();
        HashMap<String,String> map = new HashMap<String ,String>();

        String phoneNum = user.getTelephoneNum();
        String verifyCode = user.getVerifyCode();
        //验证白名单

        if("16601110171".equals(phoneNum) && "0000".equals(verifyCode)){

            map.put("userId", "417e3ef1cb264e9986992d4388bbd57e");
            map.put("userName", "admin");
            map.put("phoneNum", phoneNum);


            data.setData(map);
            data.setMessage("用户注册/登录成功");
            data.setSuccess("1");
            data.setHttpStatus(HttpStatus.gethttpStatus());

        }else {

            //先去验证码表查看该手机号是否发送过验证码，未查询到则返回验证码失效
            String codeTime = service.selectVerifyCodeExists(phoneNum, verifyCode);
            try {
                if (codeTime != null) {

                    Date nowDate = new Date();
//            Date cTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(codeTime);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date cTime = sdf.parse(codeTime);
                    //如果验证码入库时间和当前时间大于5分钟，则验证码失效
                    if (nowDate.getTime() - cTime.getTime() <= 300000) {
                        //查询用户表是否有该手机号，如果有则登陆成功，返回用户信息。如果没有则创建用户。
                        List<UserEtity> list = service.selectUser(phoneNum);
                        //如果list是空，则创建新用户
                        if (list.size() == 0) {
                            user.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
                            user.setTelephoneNum(phoneNum);
                            user.setUserName(phoneNum); //注册时，用户名默认手机号
                            service.insertUserInfo(user);
                            logger.debug("用户注册成功 |#");


                            map.put("userId", user.getUuid());
                            map.put("userName", user.getUserName());
                            map.put("phoneNum", user.getTelephoneNum());


                            data.setData(map);
                            data.setMessage("用户注册/登录成功");
                            data.setSuccess("1");
                            data.setHttpStatus(HttpStatus.gethttpStatus());
                            logger.debug("用户注册/登录成功 |#");
                        } else {
                            map.put("userId", list.get(0).getUuid());
                            map.put("userName", list.get(0).getUserName());
                            map.put("phoneNum", list.get(0).getTelephoneNum());
                            data.setData(map);
                            data.setMessage("用户登录成功");
                            data.setSuccess("1");
                            data.setHttpStatus(HttpStatus.gethttpStatus());
                            logger.debug("用户登录成功 |#");

                        }

                    } else {
                        data.setData(null);
                        data.setMessage("登陆失败，验证码超时，请重新发送验证码");
                        data.setSuccess("-1");
                        data.setHttpStatus(HttpStatus.gethttpStatus());
                        logger.debug("验证超时 |#");
                    }

                } else {
                    data.setData(null);
                    data.setMessage("登陆失败，请重新发送验证码");
                    data.setSuccess("-1");
                    data.setHttpStatus(HttpStatus.gethttpStatus());
                    logger.debug("未查询到验证码 |#");
                }
            } catch (Exception e) {
                data.setData(null);
                data.setMessage("登陆失败，后台异常");
                data.setSuccess("-1");
                data.setHttpStatus(HttpStatus.gethttpStatus());
                logger.debug("后台异常 |#");
            }
        }

            return data;
        }

    }



