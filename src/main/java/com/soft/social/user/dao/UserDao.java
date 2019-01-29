package com.soft.social.user.dao;

import com.soft.social.user.model.UserEtity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    List<UserEtity> selectUserInfo(String uuid);
}
