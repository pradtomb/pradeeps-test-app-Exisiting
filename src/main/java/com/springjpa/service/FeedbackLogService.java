package com.springjpa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.dao.FeedbackLogRepository;
import com.springjpa.dto.FeedbackLogDTO;
import com.springjpa.model.FeedbackLog;

@Service
public class FeedbackLogService {

	@Autowired
	FeedbackLogRepository feedbackLogRepository;
	
	//Insert The Data
	public FeedbackLogDTO logRequest(FeedbackLogDTO feedbackLogDTO)
	{
		FeedbackLog feedbackLog = new FeedbackLog(feedbackLogDTO.getConversationID(),
				                                    feedbackLogDTO.getFeedbackText(),
				                                    feedbackLogDTO.getFeedbackSentiment(),
				                                    feedbackLogDTO.getFeedbackRating(),
				                                    feedbackLogDTO.getFeedbacktTimestamp());
		
		feedbackLogRepository.save(feedbackLog);
		feedbackLogDTO.setFeedbackLogMessageID(feedbackLog.getFeedbackLogMessageID());
		return feedbackLogDTO;
		
	}
	
	
}
