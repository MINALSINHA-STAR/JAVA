package com.dob.scheduler.scheduler;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dob.scheduler.entity.DobSchedulerEntity;
import com.dob.scheduler.repository.DobRepository;
import com.dob.scheduler.service.DobService;

@Component
public class DobScheduler {
	@Autowired
	private DobRepository dobRepository;

	@Autowired
	private DobService dobService;

	@Scheduled(cron = "0 * * * * ?")
	public void dobScheduler() {
		try {
			LocalDate today = LocalDate.now();
			int month = today.getMonthValue();
			int day = today.getDayOfMonth();

			List<DobSchedulerEntity> users = dobRepository.findTodayBirthday(month, day);

			for (DobSchedulerEntity user : users) {
				dobService.emailService(user);
			}
			
			System.out.println("sending Birhday wishes........."+users.size());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
