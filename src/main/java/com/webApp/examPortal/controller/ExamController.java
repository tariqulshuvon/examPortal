package com.webApp.examPortal.controller;


import com.webApp.examPortal.form.ExamNameForm;
import com.webApp.examPortal.model.Exam;
import com.webApp.examPortal.service.ExamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/exam")
public class ExamController {



    @Autowired
    ExamService examService;

    @GetMapping
    public String showExamList(Model model) {
        List<ExamNameForm> examList = examService.findAll().stream()
                .map(exam ->
                        ExamNameForm.builder()
                                .id(exam.getId())
                                .examName(exam.getExamName())
                                .questionCount(examService.countQuestionsByExamId(exam.getId()))
                                .build())
                .collect(Collectors.toList());
        model.addAttribute("examList", examList);
        return "list/exam";
    }

    @GetMapping("/addNewExam")
    public String showNewExamAddingForm(Model model) {
        model.addAttribute("addNewExam", ExamNameForm.builder().build());
        return "form/newExamAddingForm";
    }

    @PostMapping
    public String saveNewExam(@Valid @ModelAttribute("saveNewExam") ExamNameForm form, BindingResult result) {
        if (form.getId() == null) {
            examService
                    .findByExamName(form.getExamName())
                    .ifPresent(name ->
                    result.rejectValue("ExamName", "error.form", form
                            .getExamName() + "already exist this category! try new"));
        }
        if (result.hasErrors()) {
            return "form/newExamAddingForm";
        }

        examService.save(Exam.builder()
                .id(form.getId())
                .examName(form.getExamName())
                .build());
        return "redirect:/exam";
    }

    @GetMapping("/editExam/{id}")
    public String editExam(Model model, @PathVariable(name = "id") long id) {
        examService.findById(id).ifPresent(form -> {
            ExamNameForm examNameForm = ExamNameForm.builder()
                    .id(form.getId())
                    .examName(form.getExamName())
                    .build();
            model.addAttribute("addNewExam", examNameForm);
        });
        return "form/newExamAddingForm";
    }

    @GetMapping("/deleteExam/{id}")
    public String deleteExam(@PathVariable(name = "id") long id) {
        examService.delete(id);
        return "redirect:/exam";
    }


}
