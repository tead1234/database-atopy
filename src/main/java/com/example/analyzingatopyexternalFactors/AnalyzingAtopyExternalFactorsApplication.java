package com.example.analyzingatopyexternalFactors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
@Slf4j
public class AnalyzingAtopyExternalFactorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyzingAtopyExternalFactorsApplication.class, args);
		log.info("hello worild");
	}
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}

}
