package com.soft.social.shareUrl.model;

import java.io.Serializable;

public class ShareUrlForAppEntity implements Serializable {

    /**
     * 共享地址Url
     */
    private String shareUrl;

    /**
     * 用户隐私政策Url
     */
    private String privacyPolicy;


    public String getShareUrl() {
        return shareUrl;
    }
    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }


    public String getPrivacyPolicy() {
        return privacyPolicy;
    }
    public void setPrivacyPolicy(String privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
    }

}
