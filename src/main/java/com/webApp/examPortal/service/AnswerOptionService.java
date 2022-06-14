package com.webApp.examPortal.service;

import com.webApp.examPortal.model.AnswerOption;
import com.webApp.examPortal.model.Question;

import java.util.List;
import java.util.Optional;

public interface AnswerOptionService {

    List<AnswerOption> findAll(Long question_id);

    Optional<AnswerOption> findById(Long id);

    public void save(AnswerOption answerOption);

    void delete(Long id);

}
