package com.springjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.dao.ApplicationExceptionLogRepository;
import com.springjpa.dao.ApplicationLogRepository;
import com.springjpa.dto.ApplicationExceptionLogDTO;
import com.springjpa.dto.ApplicationLogDTO;
import com.springjpa.model.ApplciationExceptionLog;
import com.springjpa.model.ApplciationLog;


@Service
public class ApplicationLogServices {

	@Autowired
	ApplicationLogRepository applicationLogRepository;
	
	
	public ApplicationLogDTO logException(ApplicationLogDTO appLogDTO)
	{
		ApplciationLog appLog = new ApplciationLog(appLogDTO.getComponentcode(), appLogDTO.getComponentmethod(), appLogDTO.getInput(), appLogDTO.getOutput(), appLogDTO.getLogmessage(), appLogDTO.getTimestamp());  
		applicationLogRepository.save(appLog);
		appLogDTO.setConversationmessageid(appLog.getConversationmessageid());
		return appLogDTO;
		
	}
}
