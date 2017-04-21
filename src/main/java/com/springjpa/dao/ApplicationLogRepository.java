package com.springjpa.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springjpa.model.ApplciationLog;

public interface ApplicationLogRepository extends JpaRepository<ApplciationLog, Long>{
	List<ApplciationLog> conversationmessageid(String conversationmessageid);
}