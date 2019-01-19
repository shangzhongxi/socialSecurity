package com.soft.social.common;

import com.soft.social.queryData.model.SocialSecurityBaseEntity;

import java.util.List;

public class BaseResponse<T> {
    private T data;

    private String success;

    private String message;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
