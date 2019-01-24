package com.soft.social.shareUrl.dao;

import com.soft.social.shareUrl.model.ShareUrlForAppEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ShareUrlForAppDao {
    List<ShareUrlForAppEntity> selectSocialAppUrlData();
}
