package com.soft.social.articleInfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.soft.social.articleInfo.dao.ArticleInfoDao;
import com.soft.social.articleInfo.model.ArticleInfoEntity;
import com.soft.social.articleInfo.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;

@Service("articleInfoService")
public class ArticleInfoServiceImpl implements ArticleInfoService {

    @Autowired
    private ArticleInfoDao dao;
    @Override
    public List<ArticleInfoEntity> selectArticleInfo(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<ArticleInfoEntity> list = dao.selectArticleInfo();
        return list;
    }
}
