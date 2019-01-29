package com.soft.social.user.service.impl;

import com.soft.social.user.dao.UserDao;
import com.soft.social.user.model.UserEtity;
import com.soft.social.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public List<UserEtity> selectUserInfo(String uuid) {
        return dao.selectUserInfo(uuid);
    }
}
