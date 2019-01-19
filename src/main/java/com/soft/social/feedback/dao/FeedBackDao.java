package com.soft.social.feedback.dao;

import com.soft.social.feedback.model.FeedBackEntity;
import org.springframework.stereotype.Component;

@Component
public interface FeedBackDao {
    Integer insertFeedback(FeedBackEntity feedBackMsg);
}
