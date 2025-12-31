package com.student.record.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.student.record.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<String, Long> {
    List<StudentEntity> findByCourse(String course);
    
    @Query("SELECT s FROM Student s WHERE s.course = :course AND s.status = 'ACTIVE' ")
    List<StudentEntity> findActiveStudentByCourse(@Param("course") String course);
}
