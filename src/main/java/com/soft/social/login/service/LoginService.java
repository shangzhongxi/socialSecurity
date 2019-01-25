package com.soft.social.login.service;

import com.soft.social.login.model.UserEtity;

public interface LoginService {

    String selectUser(String telephoneNum);

    Integer updateVerify(String uuid);


    Integer insertUserInfo(UserEtity user);

    Integer insertVerifyCode(String phoneNum,String verifyCode);


}
