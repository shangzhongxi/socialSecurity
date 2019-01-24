package com.soft.social.login.dao;

import org.springframework.stereotype.Component;

@Component
public interface LoginDao {
   String selectUser(String telephoneNum);

   Integer updateVerify(String uuid);

   Integer insertUserInfo(String telephoneNum,String verifyCode);
}
