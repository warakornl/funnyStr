package com.devChallenge.funnyStr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FunnyStrApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FunnyStrApplication.class, args);
	}
	
	@RequestMapping("/devchallenge")
	public String getResult(@RequestParam String funnyStr) {
		ChallengeServices serv = new ChallengeServices(funnyStr);
		String result = serv.encode();
	    return result;
	}
}
