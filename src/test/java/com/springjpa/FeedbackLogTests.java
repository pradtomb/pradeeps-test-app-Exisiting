package com.springjpa;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.springjpa.dao.FeedbackLogRepository;
import com.springjpa.model.FeedbackLog;
import com.springjpa.service.FeedbackLogService;


@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class FeedbackLogTests {
	
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	FeedbackLogRepository feedbackLogRepository;

	@Autowired
	FeedbackLogService feedbackLogService;
	
			
	@Test
	public void contextLoads()  throws Exception{
		//List<CustomerDTO> customerDTOList=customerService.getAllCustomers();		
		//assertThat(customerDTOList.size()).isEqualTo(1);
		
		
	}
	
	@Test
	public void should_find_no_should_store_a_applicationlog_if_repository_is_empty() {
		Iterable<FeedbackLog> applciationLogObj = feedbackLogRepository.findAll();
		assertThat(applciationLogObj).isEmpty();
	}
	
	@Test
	public void should_store_a_agentconversationlog() {
		FeedbackLog feedbackLogObj = feedbackLogRepository.save(new FeedbackLog("conversationID", "feedbackText", "feedbackSentiment", 
						0 , null));

		assertThat(feedbackLogObj).hasFieldOrPropertyWithValue("conversationID", "conversationID01");
		assertThat(feedbackLogObj).hasFieldOrPropertyWithValue("feedbackText", "feedbackText01");
		assertThat(feedbackLogObj).hasFieldOrPropertyWithValue("feedbackSentiment", "channelSessionID01");
		assertThat(feedbackLogObj).hasFieldOrPropertyWithValue("agentID", "agentID01");
		assertThat(feedbackLogObj).hasFieldOrPropertyWithValue("timestamp", null);	
		assertThat(feedbackLogObj).hasFieldOrPropertyWithValue("conversationSentiment", "conversationSentiment01");
		assertThat(feedbackLogObj).hasFieldOrPropertyWithValue("requestTimeStamp", "requestTimeStamp");
		
			
	}
	
	

}
