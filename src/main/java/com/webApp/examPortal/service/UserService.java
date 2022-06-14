package com.webApp.examPortal.service;



import com.webApp.examPortal.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {


    public List<User> findAll();


    User save(User user);

    Optional<User> findById(Long id);


    Optional<User> findByRoles(String roles);


    void delete(Long id);

}
