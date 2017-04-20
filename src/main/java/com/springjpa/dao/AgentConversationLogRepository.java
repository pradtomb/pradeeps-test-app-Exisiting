package com.springjpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpa.model.AgentConversationLog;

public interface AgentConversationLogRepository extends JpaRepository<AgentConversationLog, Long>{
	List<AgentConversationLog> conversationID(String conversationID);
}
