package com.webApp.examPortal.repository;


import com.webApp.examPortal.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    Integer countByExamId(Long examId);

    List<Question> findAllByExamId(Long examId);
}
