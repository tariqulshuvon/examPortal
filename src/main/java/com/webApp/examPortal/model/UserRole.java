package com.webApp.examPortal.model;

import lombok.Getter;

public enum UserRole {
    STUDENT(1L, "STUDENT"),
    TEACHER(2L, "TEACHER");

    @Getter
    private Long id;

    @Getter
    private String name;

    UserRole(Long id, String name) {

        this.id = id;
        this.name = name;
    }
}
