package com.webApp.examPortal.service;

import com.webApp.examPortal.model.AnswerOption;
import com.webApp.examPortal.repository.AnswerOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerOptionServiceImpl  implements AnswerOptionService{


    @Autowired
    AnswerOptionRepository answerOptionRepository;

    @Override
    public List<AnswerOption> findAll(Long question_id) {
        return answerOptionRepository.findAllByQuestion_id(question_id);
    }

    @Override
    public Optional<AnswerOption> findById(Long id) {
        return answerOptionRepository.findById(id);
    }


    @Override
    public void save(AnswerOption answerOption) {

        answerOptionRepository.save(answerOption);
    }

    @Override
    public void delete(Long id) {

        answerOptionRepository.deleteById(id);
    }
}
