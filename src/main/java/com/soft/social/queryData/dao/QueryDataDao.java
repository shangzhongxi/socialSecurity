package com.soft.social.queryData.dao;

import com.soft.social.queryData.model.SocialSecurityBaseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QueryDataDao {
    List<SocialSecurityBaseEntity> selectSocialSecurityData(String city);
}
