package com.soft.social.common;

import java.util.List;

public class BaseResponseList<T> extends BaseResponse{
    private List<?> data;

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

}
