package com.webApp.examPortal.form;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExamNameForm {
    private Long id;

    @NotBlank(message = "Name your exam")
    private String examName;

    private Integer questionCount;
}
