package com.dob.scheduler.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dob.scheduler.entity.DobSchedulerEntity;
import com.dob.scheduler.service.DobService;

@RestController
public class DobController {
	@Autowired
	private DobService dobService;
	
	@GetMapping("/schedule-info")
	public String dobTest() {
		System.out.println("******Scheduled time for dob******");
		return "scheduler will run at 9 a:m";
	}
}
