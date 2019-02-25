package com.innovator.portfolio.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.innovator.portfolio.domain.Quote;




public interface QuoteService {

	
	public ResponseEntity<List<Quote>> getQuotes(String query)  ;
	
}
