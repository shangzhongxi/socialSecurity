package com.soft.social.login.dao;

import com.soft.social.user.model.UserEtity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LoginDao {
   //查询用户
   List<UserEtity> selectUser(String telephoneNum);
   //查询验证码是否存在
   String selectVerifyCodeExists(@Param("phoneNum") String phoneNum, @Param("verifyCode") String verifyCode);
   //插入用户信息
   Integer insertUserInfo(UserEtity user);
   //插入验证码
   Integer insertVerifyCode(@Param("phoneNum")String phoneNum, @Param("verifyCode")String verifyCode);

}
