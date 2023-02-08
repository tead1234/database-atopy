package com.example.analyzingatopyexternalFactors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AnalyzingAtopyExternalFactorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyzingAtopyExternalFactorsApplication.class, args);
		log.info("hello worild");
	}

}
