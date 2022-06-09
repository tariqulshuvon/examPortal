package com.webApp.examPortal.form;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionAddingForm {

    private Long id;

    @NotNull(message = "Please Select any Exam")
    private Long examId;

    @NotBlank(message = "please add question")
    private String question;

    private Long mark;

}
