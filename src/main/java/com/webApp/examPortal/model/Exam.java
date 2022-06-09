package com.webApp.examPortal.model;

import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "exam")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String examName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exam",cascade = CascadeType.ALL)
    private List<Question> questionList;

}