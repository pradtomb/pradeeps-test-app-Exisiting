package com.springjpa;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springjpa.dao.ApplicationLogRepository;
import com.springjpa.model.ApplciationLog;
import com.springjpa.service.ApplicationLogServices;



@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class ApplicationLogTests {
	
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	ApplicationLogRepository applicationLogRepository;

	@Autowired
	ApplicationLogServices applicationLogService;
	
			
	@Test
	public void contextLoads()  throws Exception{
		//List<CustomerDTO> customerDTOList=customerService.getAllCustomers();		
		//assertThat(customerDTOList.size()).isEqualTo(1);
		
		
	}
	
	@Test
	public void should_find_no_applicationlog_if_repository_is_empty() {
		Iterable<ApplciationLog> applciationLogObj = applicationLogRepository.findAll();
		assertThat(applciationLogObj).isEmpty();
	}
	
	@Test
	public void should_store_a_applicationlog() {
		ApplciationLog applciationLogObj = applicationLogRepository.save(new ApplciationLog("compCode01", "compMethod01", "input01", "output01", "logmessage", null));

		assertThat(applciationLogObj).hasFieldOrPropertyWithValue("componentcode", "compCode01");
		assertThat(applciationLogObj).hasFieldOrPropertyWithValue("componentmethod", "compMethod01");
		assertThat(applciationLogObj).hasFieldOrPropertyWithValue("input", "input01");
		assertThat(applciationLogObj).hasFieldOrPropertyWithValue("output", "output01");
		assertThat(applciationLogObj).hasFieldOrPropertyWithValue("logmessage", "logmessage");
		assertThat(applciationLogObj).hasFieldOrPropertyWithValue("timestamp", null);		
	}
	
	

}
