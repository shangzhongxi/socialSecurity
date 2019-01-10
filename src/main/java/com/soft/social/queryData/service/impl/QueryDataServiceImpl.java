package com.soft.social.queryData.service.impl;

import com.soft.social.queryData.dao.QueryDataDao;
import com.soft.social.queryData.model.SocialSecurityBaseEntity;
import com.soft.social.queryData.service.QueryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "QueryDataService")
public class QueryDataServiceImpl implements QueryDataService {

    @Autowired
    private QueryDataDao dao;

    @Override
    public List<SocialSecurityBaseEntity> selectSocialSecurity(String city) {
        return dao.selectSocialSecurityData(city);
    }
}
