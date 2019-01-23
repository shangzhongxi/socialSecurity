package com.soft.social.articleInfo.controller;

import com.soft.social.articleInfo.model.ArticleInfoEntity;
import com.soft.social.articleInfo.service.ArticleInfoService;
import com.soft.social.common.BaseResponse;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/article")
public class ArticleInfoController {

    private Logger logger = LoggerFactory.getLogger(ArticleInfoController.class);
    private String logtitle = "查询新闻列表信息|#";

    @Autowired
    private ArticleInfoService service;

    @GetMapping(value = "/queryList")
    @ResponseBody
    @ApiOperation(value = "查询新闻列表信息",notes = "查询新闻列表信息")
    public BaseResponse queryList(@RequestParam(value = "pageNum") int pageNum,
                                  @RequestParam(value = "pageSize") int pageSize ){
        HttpServletResponse httpServletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        int status = httpServletResponse.getStatus();
        BaseResponse<ArticleInfoEntity> data = new BaseResponse<ArticleInfoEntity>();
        try{
            List<ArticleInfoEntity> list = service.selectArticleInfo(pageNum,pageSize);
            data.setData(list.get(0));
            data.setMessage("新闻列表信息查询成功");
            data.setSuccess("1");
            data.setHttpStatus(status);
        }catch (Exception e){
            data.setData(null);
            data.setMessage("新闻列表信息查询失败");
            data.setSuccess("-1");
            data.setHttpStatus(status);
        }

        return data;
    }
}
