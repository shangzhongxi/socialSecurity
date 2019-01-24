package com.soft.social.shareUrl.model;

import java.io.Serializable;

public class ShareUrlForAppEntity implements Serializable {

    /**
     * 共享地址
     */
    private String shareUrl;

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }
}
