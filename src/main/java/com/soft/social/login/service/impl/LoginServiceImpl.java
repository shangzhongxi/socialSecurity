package com.soft.social.login.service.impl;

import com.soft.social.login.dao.LoginDao;
import com.soft.social.user.model.UserEtity;
import com.soft.social.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao dao;

    @Override
    public List<UserEtity> selectUser(String telephoneNum) throws Exception {
        return dao.selectUser(telephoneNum);
    }

    @Override
    public String selectVerifyCodeExists(String phoneNum, String verifyCode) throws Exception {
        return dao.selectVerifyCodeExists(phoneNum,verifyCode);
    }

    @Override
    public Integer insertUserInfo(UserEtity user) throws Exception {
        return dao.insertUserInfo(user);
    }

    @Override
    public Integer insertVerifyCode(String phoneNum, String verifyCode) throws Exception {
        return dao.insertVerifyCode(phoneNum,verifyCode);
    }


}
