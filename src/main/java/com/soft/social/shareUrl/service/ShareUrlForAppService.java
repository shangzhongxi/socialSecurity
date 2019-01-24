package com.soft.social.shareUrl.service;

import com.soft.social.shareUrl.model.ShareUrlForAppEntity;

import java.util.List;

public interface ShareUrlForAppService {
    List<ShareUrlForAppEntity> selectSocialAppUrl();
}
