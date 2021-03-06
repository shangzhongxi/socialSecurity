package com.soft.social.queryData.controller;


import com.soft.social.common.BaseResponse;
import com.soft.social.common.BaseResponseSingle;
import com.soft.social.common.HttpStatus;
import com.soft.social.queryData.model.SocialSecurityBaseEntity;
import com.soft.social.queryData.service.QueryDataService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
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
    @ApiOperation(value = "查询城市基础社保信息",notes = "查询城市基础社保信息")
    public BaseResponse queryData(String city){
        BaseResponseSingle<SocialSecurityBaseEntity> data = new BaseResponseSingle<SocialSecurityBaseEntity>();
        try {

            List<SocialSecurityBaseEntity> list =  service.selectSocialSecurity(city);
            data.setData(list.get(0));
            data.setMessage(city + " 数据查询成功");
            data.setSuccess("1");
            data.setHttpStatus(HttpStatus.gethttpStatus());
        }catch (Exception e){
            data.setData(null);
            data.setMessage(city + " 数据查询失败");
            data.setSuccess("-1");
            data.setHttpStatus(HttpStatus.gethttpStatus());
        }

        return data;
    }
}
