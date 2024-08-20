package com.jsp.FinalAssessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.jsp.newcurdoperation")
public class FinalAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalAssessmentApplication.class, args);
	}

}
