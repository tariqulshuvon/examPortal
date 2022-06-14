package com.webApp.examPortal.controller;


import com.webApp.examPortal.form.AnswerOptionForm;
import com.webApp.examPortal.model.AnswerOption;
import com.webApp.examPortal.service.AnswerOptionService;
import com.webApp.examPortal.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/option")
public class AnswerOptionController {




    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerOptionService answerOptionService;


    @GetMapping("/{question_id}")
    public String showOptionList(@PathVariable(name = "question_id") Long question_id, Model model) {
        List<AnswerOption> answerOptionList = answerOptionService.findAll(question_id);
        model.addAttribute("answerOptionList", answerOptionList);
        return "list/answerOptionList";
    }

    @GetMapping("/addNewAnswerOption")
    public String showAnswerOptionAddingForm(Model model) {
        model.addAttribute("option", AnswerOptionForm.builder().build());
        return "form/newAnswerOptionAddingForm";
    }


    @PostMapping
    public String saveQuestion(@Valid @ModelAttribute("option") AnswerOptionForm form, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("answerOptionList", questionService.findAll());
            return "form/newAnswerOptionAddingForm";
        }

        questionService.findById(form.getId()).ifPresent(questionId -> {
            answerOptionService.save(AnswerOption.builder()
                    .id(form.getId())
                    .question(questionId)
                    .option(form.getOption())
                    .build());
        });

        return "redirect:/answerOption";
    }


    @GetMapping("editAnswerOption/{id}")
    public String showEditAnswerOptionForm(Model model, @PathVariable(name = "id") long id) {
        answerOptionService.findById(id).ifPresent(qid -> {
            AnswerOptionForm form = AnswerOptionForm.builder()
                    .id(qid.getId())
                    .questionId(qid.getQuestion().getId())
                    .option(qid.getOption())
                    .build();
            model.addAttribute("option", form);
            model.addAttribute("question", questionService.findAll());
        });
        return "form/newAnswerOptionAddingForm";

    }

    @RequestMapping("/deleteAnswerOption/{id}")
    public String deleteAnswerOption(@PathVariable(name = "id") long id) {
        answerOptionService.delete(id);
        return "redirect:/option";
    }


}
