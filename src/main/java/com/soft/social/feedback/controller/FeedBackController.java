package com.soft.social.feedback.controller;

import com.soft.social.common.BaseResponse;
import com.soft.social.feedback.model.FeedBackEntity;
import com.soft.social.feedback.service.FeedBackService;
import com.soft.social.queryData.controller.QueryDataController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/feedback")
public class FeedBackController {
    private Logger logger = LoggerFactory.getLogger(FeedBackController.class);
    private String logtitle = "增加反馈信息接口 |#";

    @Autowired
    private FeedBackService service;

    BaseResponse data = null;

    @GetMapping(value = "/insertMsg")
    @ResponseBody
    public BaseResponse insertFeedBackMsg(@RequestParam(value = "feedBackDetail" ) String feedBackDetail,
                                          @RequestParam(value = "userid" ,required = false,defaultValue = "youke") String userid){
        BaseResponse<String> data = new BaseResponse<String>();
        try {
            FeedBackEntity feedBackMsg = new FeedBackEntity();
            feedBackMsg.setFeedBack(feedBackDetail);
            feedBackMsg.setUserId(userid);
            int i = service.insertFeedback(feedBackMsg);
            if (i > 0) {
                data.setData("TRUE");
                data.setMessage("反馈信息插入成功");
                data.setSuccess("1");
            } else {
                data.setData("FALSE");
                data.setMessage("反馈信息插入失败");
                data.setSuccess("-2");
            }
        }catch (Exception e){
            e.printStackTrace();
            data.setData("FALSE");
            data.setMessage("系统异常，反馈信息插入失败");
            data.setSuccess("-1");
        }
        return data;
    }

}
