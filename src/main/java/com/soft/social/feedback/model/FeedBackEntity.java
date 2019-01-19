package com.soft.social.feedback.model;

import java.io.Serializable;

public class FeedBackEntity  implements Serializable {

    /**
     * 反馈内容
     */
    private String feedBack;

    /**
     * 用户uuid
     * @return
     */
    private String userId;

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
