package com.webApp.examPortal.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationForm {

    private Long id;
    private String name;
    private String email;
    private String password;

}
