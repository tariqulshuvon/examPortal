package com.webApp.examPortal.repository;


import com.webApp.examPortal.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Long> {
    Optional<Exam> findByExamName(String examName);

}
