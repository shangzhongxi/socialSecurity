package com.soft.social.user.service;

import com.soft.social.user.model.UserEtity;

import java.util.List;

public interface UserService {
    List<UserEtity> selectUserInfo(String uuid);
}
