package com.example.MovieApp.user.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
public class RegisterUserRequest {
    private String username;
    private String email;
    private String password;
}


