package com.webApp.examPortal.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    Exam exam;

    @Column
    private String question;


    @Column
    private Long mark;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question",cascade = CascadeType.ALL)
    private List<AnswerOption> answerOptionList;

}