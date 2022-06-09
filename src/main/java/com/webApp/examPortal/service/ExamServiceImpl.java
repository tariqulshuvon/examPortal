package com.webApp.examPortal.service;

import com.webApp.examPortal.model.Exam;
import com.webApp.examPortal.repository.ExamRepository;
import com.webApp.examPortal.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {


    @Autowired
    ExamRepository examRepository;


    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Exam> findAll() {
        return examRepository.findAll();
    }

    @Override
    public void save(Exam exam) {
        examRepository.save(exam);
    }

    @Override
    public void delete(Long id) {
        examRepository.deleteById(id);
    }

    @Override
    public Optional<Exam> findById(Long id) {
        return examRepository.findById(id);
    }

    @Override
    public Optional<Exam> findByExamName(String examName) {
        return examRepository.findByExamName(examName);
    }

    public Integer countQuestionsByExamId(Long examId) {
        return questionRepository.countByExamId(examId);
    }
}
