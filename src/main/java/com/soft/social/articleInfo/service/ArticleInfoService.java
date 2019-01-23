package com.soft.social.articleInfo.service;

import com.soft.social.articleInfo.model.ArticleInfoEntity;

import java.util.List;

public interface ArticleInfoService {
    List<ArticleInfoEntity> selectArticleInfo(int pageNum,int pageSize) throws Exception;

}
