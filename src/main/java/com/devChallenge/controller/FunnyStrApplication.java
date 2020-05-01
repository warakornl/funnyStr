package com.devChallenge.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@SpringBootApplication
@RestController
public class FunnyStrApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FunnyStrApplication.class, args);
	}
	
	@RequestMapping("/devchallenge")
	public String getResult(@RequestParam String funnyStr) {
		ChallengeServices serv = new ChallengeServices(funnyStr);
		String result = null;
		try {
			result = serv.encode();
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		 return result;
		
	}
}
