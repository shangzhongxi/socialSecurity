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

    /**
     * google广告是否展示
     */
    private String showGoogleAd;


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

    public String getShowGoogleAd() {
        return showGoogleAd;
    }
    public void seshowGoogleAd(String showGoogleAd) { this.showGoogleAd = showGoogleAd; }

}
