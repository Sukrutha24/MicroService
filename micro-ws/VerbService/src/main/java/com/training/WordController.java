package com.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
	
	@Value("${greeting.title}")
	String greeting;

	@GetMapping("/word")
	public String getWord() {
		return greeting;
	}
}
