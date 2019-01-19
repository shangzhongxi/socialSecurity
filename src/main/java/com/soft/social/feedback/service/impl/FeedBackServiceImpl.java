package com.soft.social.feedback.service.impl;

import com.soft.social.feedback.dao.FeedBackDao;
import com.soft.social.feedback.model.FeedBackEntity;
import com.soft.social.feedback.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedBackDao dao;

    @Override
    public Integer insertFeedback(FeedBackEntity feedBackMsg) {
        return dao.insertFeedback(feedBackMsg);
    }
}
