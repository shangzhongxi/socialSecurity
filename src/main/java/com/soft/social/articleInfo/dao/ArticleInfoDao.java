package com.soft.social.articleInfo.dao;

import com.soft.social.articleInfo.model.ArticleInfoEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleInfoDao {
    List<ArticleInfoEntity> selectArticleInfo() throws Exception;
}
