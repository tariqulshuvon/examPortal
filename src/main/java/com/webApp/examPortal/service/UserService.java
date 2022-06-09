package com.webApp.examPortal.service;



import com.webApp.examPortal.form.UserRegistrationForm;
import com.webApp.examPortal.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationForm userRegistrationForm);
}
