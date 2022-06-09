package com.webApp.examPortal.form;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerOptionForm  {

    private Long id;


    @NotNull(message = "Please Select any Question")
    private Long questionId;

//    private Long rightAnswerId;

    private String option;

}
