package com.soft.social.shareUrl.controller;


import com.soft.social.common.BaseResponse;
import com.soft.social.common.BaseResponseSingle;
import com.soft.social.common.HttpStatus;
import com.soft.social.shareUrl.model.ShareUrlForAppEntity;
import com.soft.social.shareUrl.service.ShareUrlForAppService;
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
    @RequestMapping(value = "/appConfig")
public class ShareUrlForAppController {

    private Logger logger = LoggerFactory.getLogger(ShareUrlForAppController.class);
    private String logtitle = "查询共享APP URL|#";

    @Autowired
    private ShareUrlForAppService service;

    @ResponseBody
    @GetMapping(value = "/appConfigData")
    @ApiOperation(value = "查询共享APP URL",notes = "查询共享APP URL")
    public BaseResponse queryUrl(){
        BaseResponseSingle<ShareUrlForAppEntity> data = new BaseResponseSingle<ShareUrlForAppEntity>();
        try {
            List<ShareUrlForAppEntity> list =  service.selectSocialAppUrl();
            data.setData(list.get(0));
            data.setMessage(" 数据查询成功");
            data.setSuccess("1");
            data.setHttpStatus(HttpStatus.gethttpStatus());
        }catch (Exception e){
            e.printStackTrace();
            data.setData(null);
            data.setMessage(" 数据查询失败");
            data.setSuccess("-1");
            data.setHttpStatus(HttpStatus.gethttpStatus());
        }

        return data;
    }
}
