package com.springjpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpa.model.BotConversationLog;

public interface BotConversationLogRepository extends JpaRepository<BotConversationLog, Long>{
	List<BotConversationLog> conversationId(String conversationId);
}
