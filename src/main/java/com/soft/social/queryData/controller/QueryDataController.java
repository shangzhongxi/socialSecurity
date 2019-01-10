package com.soft.social.queryData.controller;


import com.soft.social.common.BaseResponse;
import com.soft.social.queryData.model.SocialSecurityBaseEntity;
import com.soft.social.queryData.service.QueryDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/queryCity")
public class QueryDataController {

    private Logger logger = LoggerFactory.getLogger(QueryDataController.class);
    private String logtitle = "查询城市基础社保数据信息|#";

    @Autowired
    private QueryDataService service;
    @ResponseBody
    @GetMapping(value = "/cityBaseData")
    public BaseResponse queryData(String city){
        BaseResponse data = new BaseResponse();
        try {
            List<SocialSecurityBaseEntity> list =  service.selectSocialSecurity(city);
            data.setData(list);
            data.setMessage(city + " 数据查询成功");
            data.setSuccess("√");
        }catch (Exception e){
            data.setMessage(city + " 数据查询失败");
            data.setSuccess("×");
        }

        return data;
    }
}
