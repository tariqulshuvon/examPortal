package com.webApp.examPortal.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "answerOption")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "rightAnswer_id", nullable = false)
//    RightAnswer rightAnswer;
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    Question question;


    @Column
    private String option;

}
