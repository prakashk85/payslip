package com.au.prakash.tax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.au.prakash.tax" })
public class PaySlipApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaySlipApplication.class, args);
	}

}