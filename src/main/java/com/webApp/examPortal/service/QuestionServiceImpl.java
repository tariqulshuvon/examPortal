package com.webApp.examPortal.service;


import com.webApp.examPortal.model.Question;
import com.webApp.examPortal.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService{


    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Question> findAll(Long examId) {
        return questionRepository.findAllByExamId(examId);
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }


    @Override
    public void save(Question question) {

        questionRepository.save(question);
    }

    @Override
    public void delete(Long id) {

        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }
}
