package com.springjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.dao.ApplicationExceptionLogRepository;
import com.springjpa.dto.ApplicationExceptionLogDTO;
import com.springjpa.model.ApplciationExceptionLog;


@Service
public class ApplicationExceptionLogServices {

	@Autowired
	ApplicationExceptionLogRepository applicationExceptionRepository;
	
	
	public ApplicationExceptionLogDTO logException(ApplicationExceptionLogDTO appExceptinoDTO)
	{
		ApplciationExceptionLog appExceptinoLog = new ApplciationExceptionLog(appExceptinoDTO.getExceptiontimestamp(), appExceptinoDTO.getConversationId(), appExceptinoDTO.getErrorCode(), appExceptinoDTO.getErrorMessage(), appExceptinoDTO.getSource());  
		applicationExceptionRepository.save(appExceptinoLog);
		appExceptinoDTO.setApplicationexceptionid(appExceptinoLog.getApplicationexceptionid());
		return appExceptinoDTO;
		
	}
}
