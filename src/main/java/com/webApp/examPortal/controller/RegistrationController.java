package com.webApp.examPortal.controller;

import com.webApp.examPortal.form.UserRegistrationForm;
import com.webApp.examPortal.model.User;
import com.webApp.examPortal.model.UserRole;
import com.webApp.examPortal.service.RoleService;
import com.webApp.examPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", UserRegistrationForm.builder().build());
        return "registrationForm/student";
    }

    @PostMapping("/student")
    public String saveUser(@ModelAttribute UserRegistrationForm form) {
        User user = User.builder()
                .username(form.getUsername())
                .password(form.getPassword())
                .roles(List.of(roleService.findById(UserRole.STUDENT.getId())))
                .build();
        userService.save(user);
        return "redirect:/login";
    }


    @PostMapping("/teacher")
    public String saveUser(@ModelAttribute("teacher") UserRegistrationForm form, Model model) {
        User user = null;

        if (form.getId() != null) {
            user = userService.findById(form.getId()).orElse(null);
            if (user != null) {
                user.setUsername(form.getUsername());
                userService.save(user);
            }
        } else {
            user = User.builder()
                    .username(form.getUsername())
                    .password(form.getPassword())
                    .roles(List.of(roleService.findById(UserRole.TEACHER.getId())))
                    .build();
            userService.save(user);
        }

        return "redirect:/teachers";

    }

}
