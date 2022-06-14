package com.webApp.examPortal.service;



import com.webApp.examPortal.form.UserRegistrationForm;
import com.webApp.examPortal.model.Role;
import com.webApp.examPortal.model.User;
import com.webApp.examPortal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    UserRepository userRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//



//    @Override
//    public User save(UserRegistrationForm userRegistrationForm) {
//
//        User user = new User(userRegistrationForm.getId(),
//                userRegistrationForm.getName(),
//                userRegistrationForm.getEmail(),
//                passwordEncoder.encode(userRegistrationForm.getPassword()),
//                Arrays.asList(new Role("STUDENT")));
//
//        return userRepository.save(user);
//    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private List<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByRoles(String roles) {
        return Optional.ofNullable(userRepository.findByRoles(roles));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }



}
