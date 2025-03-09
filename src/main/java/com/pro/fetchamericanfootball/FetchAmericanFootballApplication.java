package com.pro.fetchamericanfootball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FetchAmericanFootballApplication {

	public static void main(String[] args) {
		SpringApplication.run(FetchAmericanFootballApplication.class, "--server.port=8081");
	}
}