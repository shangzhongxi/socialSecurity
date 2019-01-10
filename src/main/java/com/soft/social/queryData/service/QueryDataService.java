package com.soft.social.queryData.service;

import com.soft.social.queryData.model.SocialSecurityBaseEntity;

import java.util.List;

public interface QueryDataService {
    List<SocialSecurityBaseEntity> selectSocialSecurity(String city);
}
