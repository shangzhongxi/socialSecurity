package com.soft.social.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class HttpStatus {
    public static Integer gethttpStatus(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse().getStatus();
    }
}
