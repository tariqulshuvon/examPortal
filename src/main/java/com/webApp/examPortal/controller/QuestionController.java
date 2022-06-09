package com.webApp.examPortal.controller;


import com.webApp.examPortal.form.QuestionAddingForm;
import com.webApp.examPortal.model.Question;
import com.webApp.examPortal.service.ExamService;
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
@RequestMapping("/question")
public class QuestionController {


    @Autowired
    private QuestionService questionService;

    @Autowired
    private ExamService examService;


    @GetMapping
    public String showQuestionList(Model model) {
        List<Question> questionList = questionService.findAll();
        model.addAttribute("questionList", questionList);
        return "list/questionList";
    }

    @GetMapping("/addNewQuestion")
    public String showQuestionAddingForm(Model model) {
        model.addAttribute("question", QuestionAddingForm.builder().build());
        model.addAttribute("examList", examService.findAll());
        return "form/newQuestionAddingForm";
    }


    @PostMapping
    public String saveQuestion(@Valid @ModelAttribute("question") QuestionAddingForm form, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("examList", examService.findAll());
            return "form/newQuestionAddingForm";
        }

        examService.findById(form.getExamId()).ifPresent(examId -> {
            questionService.save(Question.builder()
                    .id(form.getId())
                    .exam(examId)
                    .question(form.getQuestion())
                    .mark(form.getMark())
                    .build());
        });

        return "redirect:/question";
    }


    @GetMapping("editQuestion/{id}")
    public String showEditQuestionForm(Model model, @PathVariable(name = "id") long id) {
        questionService.findById(id).ifPresent(qid -> {
            QuestionAddingForm form = QuestionAddingForm.builder()
                    .id(qid.getId())
                    .examId(qid.getExam().getId())
                    .question(qid.getQuestion())
                    .mark(qid.getMark())
                    .build();
            model.addAttribute("question", form);
            model.addAttribute("examList", examService.findAll());
        });
        return "form/newQuestionAddingForm";

    }

    @RequestMapping("/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable(name = "id") long id) {
        questionService.delete(id);
        return "redirect:/question";
    }

}