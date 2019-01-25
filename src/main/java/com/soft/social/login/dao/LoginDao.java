package com.soft.social.login.dao;

import com.soft.social.login.model.UserEtity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface LoginDao {
   String selectUser(String telephoneNum);

   Integer updateVerify(String uuid);

   Integer insertUserInfo(UserEtity user);

   Integer insertVerifyCode(@Param("phoneNum")String phoneNum, @Param("verifyCode")String verifyCode);
}
