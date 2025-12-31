package com.dob.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBoot08SpringSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot08SpringSchedulerApplication.class, args);
	}

}
