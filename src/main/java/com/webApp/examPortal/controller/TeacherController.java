package com.webApp.examPortal.controller;


import com.webApp.examPortal.form.UserRegistrationForm;
import com.webApp.examPortal.model.User;
import com.webApp.examPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    UserService userService;

    @GetMapping
    public String showAdmins(Authentication authentication, Model model) {

        List<User> teachers = userService.findAll();

        model.addAttribute("teachers",teachers);

        return "list/teachers";
    }

    @GetMapping("/new")
    public String showCreate(Model model) {
        model.addAttribute("teachers", UserRegistrationForm.builder().build());
        return "registrationForm/teacher";
    }


    @GetMapping("/edit/{id}")
    public String editBookForm(Model model, @PathVariable(name = "id") long id) {
        userService.findById(id).ifPresent(form-> {
            UserRegistrationForm userRegistrationForm = UserRegistrationForm.builder()
                    .id(form.getId())
                    .username(form.getUsername())
                    .password(form.getPassword())
                    .build();
            model.addAttribute("teachers",userRegistrationForm);
        });
        return "registrationForm/teacher";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") long id) {
        userService.delete(id);
        return "redirect:/teachers";
    }


}
