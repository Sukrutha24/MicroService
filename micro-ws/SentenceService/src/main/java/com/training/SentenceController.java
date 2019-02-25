package com.training;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class SentenceController {
	/*
	 * @Autowired DiscoveryClient client;
	 */
	@Autowired
	RestTemplate restClient;
	
	@GetMapping("/sentence")
	@HystrixCommand(fallbackMethod="fallbackSentence")
	public String createSentence() {
		/*
		 * List<ServiceInstance> instances=client.getInstances("verb"); ServiceInstance
		 * instance=instances.get(0); String uri=instance.getUri().toString();
		 */
		//RestTemplate restClient=new RestTemplate();
		
		String response=restClient.getForObject("http://verb/word",String.class);
		
		return "Sentence created using "+response+" word";
	}
	
	
	public String fallbackSentence() {
		return "fallback method executed()";
	}
}
