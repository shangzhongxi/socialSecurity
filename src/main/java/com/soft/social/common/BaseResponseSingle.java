package com.soft.social.common;

public class BaseResponseSingle<T> extends BaseResponse{

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
