package com.webApp.examPortal.service;

import com.webApp.examPortal.model.Exam;
import com.webApp.examPortal.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<Question> findAll();

    Optional<Question> findById(Long id);

    public void save(Question question);

    void delete(Long id);


}
