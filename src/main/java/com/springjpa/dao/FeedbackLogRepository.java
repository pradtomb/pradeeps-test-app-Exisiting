package com.springjpa.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpa.model.FeedbackLog;

public interface FeedbackLogRepository extends JpaRepository<FeedbackLog, Long>{

}
