package com.webApp.examPortal.repository;


import com.webApp.examPortal.model.AnswerOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerOptionRepository extends JpaRepository<AnswerOption,Long> {

    Optional<AnswerOption> findByOption(String option);

    List<AnswerOption> findAllByQuestion_id(Long question_id);
}
