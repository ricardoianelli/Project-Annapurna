package edu.miu.emailservice.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class User {
    @NotBlank
    String name;
    @Email
    String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
