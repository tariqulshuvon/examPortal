package com.webApp.examPortal.service;


import com.webApp.examPortal.model.Exam;

import java.util.List;
import java.util.Optional;

public interface ExamService {

    List<Exam> findAll();

    Optional<Exam> findById(Long id);

    Optional<Exam> findByExamName(String examName);

    void save(Exam exam);

    void delete(Long id);
    
    public Integer countQuestionsByExamId(Long examId);
    
}
