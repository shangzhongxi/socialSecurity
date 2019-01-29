package com.soft.social.login.service;

import com.soft.social.user.model.UserEtity;

import java.util.List;

public interface LoginService {
    //查询用户
    List<UserEtity> selectUser(String telephoneNum) throws Exception;
    //查询验证码是否存在
    String selectVerifyCodeExists(String phoneNum, String verifyCode) throws Exception;
    //插入用户信息
    Integer insertUserInfo(UserEtity user) throws Exception;
    //插入验证码
    Integer insertVerifyCode(String phoneNum,String verifyCode) throws Exception;


}
