package com.soft.social.shareUrl.service.impl;

import com.soft.social.shareUrl.dao.ShareUrlForAppDao;
import com.soft.social.shareUrl.model.ShareUrlForAppEntity;
import com.soft.social.shareUrl.service.ShareUrlForAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "ShareUrlForAppService")
public class ShareUrlForAppServiceImpl implements ShareUrlForAppService {

    @Autowired
    private ShareUrlForAppDao dao;

    @Override
    public List<ShareUrlForAppEntity> selectSocialAppUrl() {
        return dao.selectSocialAppUrlData();
    }

}
