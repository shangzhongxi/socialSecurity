package com.soft.social.login.controller;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.soft.social.common.*;
import com.soft.social.login.model.UserEtity;
import com.soft.social.login.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

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

    public void login(){

        String uuid = service.selectUser("1");
        //如果用户不存在，则创建用户
        if (uuid == null) {
            UserEtity user = new UserEtity();

            user.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
            user.setTelephoneNum("1");
            //user.setVerifyCode(result.toString());
            user.setVerifyCode("1");
            service.insertUserInfo(user);
        } else {
            //如果存在，则更新验证码
            //service.updateVerify(result.toString());
            service.updateVerify("1");

        }
    }
}
