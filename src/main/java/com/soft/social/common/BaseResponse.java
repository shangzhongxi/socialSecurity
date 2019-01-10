package com.soft.social.common;

import com.soft.social.queryData.model.SocialSecurityBaseEntity;

public class BaseResponse extends BaseStatus{
    private SocialSecurityBaseEntity Data;

    public SocialSecurityBaseEntity getData() {
        return Data;
    }

    public void setData(SocialSecurityBaseEntity data) {
        Data = data;
    }
}
