package com.webApp.examPortal.controller;



import com.webApp.examPortal.model.Exam;
import com.webApp.examPortal.model.User;
import com.webApp.examPortal.service.ExamService;
import com.webApp.examPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/students")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String exams(Model model) {

        List<User> userList = userService.findAll();
        model.addAttribute("students",userList);

        return "list/students";
    }

}
