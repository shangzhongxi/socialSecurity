package com.soft.social.login.service.impl;

import com.soft.social.login.dao.LoginDao;
import com.soft.social.login.model.UserEtity;
import com.soft.social.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao dao;

    @Override
    public String selectUser(String telephoneNum) {
        return dao.selectUser(telephoneNum);
    }

    @Override
    public Integer updateVerify(String uuid) {
        return dao.updateVerify(uuid);
    }

    @Override
    public Integer insertUserInfo(UserEtity user) {
        return dao.insertUserInfo(user);
    }

    @Override
    public Integer insertVerifyCode(String phoneNum, String verifyCode) {
        return dao.insertVerifyCode(phoneNum,verifyCode);
    }

}
