package com.innovator.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.innovator.repository.AccountRepository;
import com.innovator.repository.JdbcAccountRepositoryImpl;
import com.innovator.repository.JdbcRewardRepositoryImpl;
import com.innovator.repository.JdbcTransactionRepositoryImpl;
import com.innovator.repository.RewardRepository;
import com.innovator.repository.TransactionRepository;
import com.innovator.service.BankService;
import com.innovator.service.BankServiceImpl;
import com.innovator.service.EmailService;
import com.innovator.service.EmailServiceImpl;

	@Configuration
	//@Import(InfrastructureConfig.class)
	public class ApplicationConfig {
		
		@Autowired
		private DataSource dataSource;
		
		
		
		@Bean
		public AccountRepository accountRepository(){		
			return new JdbcAccountRepositoryImpl(dataSource);			
		}		
		
		@Bean
		public RewardRepository rewardRepository(){
			return  new JdbcRewardRepositoryImpl(dataSource);
		}
		@Bean
		public TransactionRepository transactionRepository(){
			return new JdbcTransactionRepositoryImpl(dataSource);
		}
		
		
		@Bean
		public EmailService emailService(){
			return new EmailServiceImpl();
		}
		
		@Bean
		public BankService bankService(){
			BankServiceImpl bankServiceImpl= new BankServiceImpl();
			bankServiceImpl.setAccountRepository(accountRepository());
			bankServiceImpl.setEmailService(emailService());
			bankServiceImpl.setRewardRepository(rewardRepository());
			bankServiceImpl.setTransactionRepository(transactionRepository());
			return bankServiceImpl;
		}
	
	}
