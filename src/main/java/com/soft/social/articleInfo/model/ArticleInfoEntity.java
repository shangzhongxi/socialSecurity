package com.soft.social.articleInfo.model;

import java.io.Serializable;

public class ArticleInfoEntity implements Serializable {

    /**
     * 新闻id
     */
    private Integer id;
    /**
     * 新闻标题
     */
    private String articleTitle;
    /**
     * 新闻来源
     */
    private String articleSource;
    /**
     * 新闻时间
     */
    private String articleTime;
    /**
     * 新闻链接
     */
    private String articleUrl;
    /**
     * 图片链接
     */
    private String imgUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleSource() {
        return articleSource;
    }

    public void setArticleSource(String articleSource) {
        this.articleSource = articleSource;
    }

    public String getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(String articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
