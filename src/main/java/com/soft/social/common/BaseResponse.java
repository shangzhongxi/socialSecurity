package com.soft.social.common;

import java.util.List;

public class BaseResponse extends BaseStatus{
    private List<?> Data;

    public List<?> getData() {
        return Data;
    }

    public void setData(List<?> data) {
        Data = data;
    }
}
