package com.example.MovieApp.user.application.dto;

import com.example.MovieApp.user.domain.Email;
import lombok.Value;

@Value
public class RegisterUserCommand {
    String username;
    Email email;
    String password;
}

