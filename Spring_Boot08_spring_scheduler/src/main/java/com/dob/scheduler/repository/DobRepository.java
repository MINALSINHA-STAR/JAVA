package com.dob.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dob.scheduler.entity.DobSchedulerEntity;
import java.util.List;
import java.time.LocalDate;


@Repository
public interface DobRepository extends JpaRepository<DobSchedulerEntity, Integer> {
	@Query("SELECT d FROM DobSchedulerEntity d "+" WHERE MONTH(d.dob) = :month AND DAY(d.dob) = :day" )
	List<DobSchedulerEntity> findTodayBirthday(int month,int day);
}
