package com.dob.scheduler.service;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.message.SimpleMessageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.dob.scheduler.entity.DobSchedulerEntity;
import com.dob.scheduler.repository.DobRepository;

@Service
public class DobService {

	// @Autowired
	// private DobRepository dobRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	public void emailService(DobSchedulerEntity dobSchedulerEntity) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(dobSchedulerEntity.getEmail());

		mailMessage.setSubject("*** Happy Birthday ***");

		mailMessage.setText("Dear " + dobSchedulerEntity.getFirstName() + " Wishing you a very Happy Birthday!");
		javaMailSender.send(mailMessage);

		System.out.println("sending birthday wishes to: " + dobSchedulerEntity.getEmail());

	}
}
