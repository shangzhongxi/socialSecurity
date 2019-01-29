package com.soft.social.user.controller;

import com.soft.social.common.BaseResponseSingle;
import com.soft.social.common.HttpStatus;
import com.soft.social.user.model.UserEtity;
import com.soft.social.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private String logtitle = "登陆 |#";

    @Autowired
    private UserService service;

    @ResponseBody
    @GetMapping(value = "userInfo")
    @ApiOperation(value = "返回用户信息",notes = "返回用户信息")
    public BaseResponseSingle queryUserInfo( String userId){
        BaseResponseSingle<HashMap<String,String>> data = new BaseResponseSingle<HashMap<String,String>>();
        HashMap<String,String> map = new HashMap<String ,String>();
        try {
            List<UserEtity> list = service.selectUserInfo(userId);

            map.put("userId",list.get(0).getUuid());
            map.put("userName",list.get(0).getUserName());
            map.put("phoneNum",list.get(0).getTelephoneNum());

            data.setData(map);
            data.setMessage("用户信息返回成功");
            data.setSuccess("1");
            data.setHttpStatus(HttpStatus.gethttpStatus());
            logger.debug("用户信息返回成功 |#");
        }catch (Exception e){
            e.printStackTrace();
            data.setData(null);
            data.setMessage("用户信息返回失败");
            data.setSuccess("1");
            data.setHttpStatus(HttpStatus.gethttpStatus());
            logger.debug("用户信息返回失败 |#");

        }
        return data;

    }
}
