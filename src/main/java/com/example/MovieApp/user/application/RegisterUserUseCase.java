package com.example.MovieApp.user.application;

import com.example.MovieApp.user.application.dto.RegisterUserRequest;
import com.example.MovieApp.user.domain.Email;
import com.example.MovieApp.user.domain.UserRepository;
import com.example.MovieApp.user.domain.Username;
import com.example.MovieApp.user.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class RegisterUserUseCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterUserRequest request){
        Username username = new Username(request.getUsername());
        Email email = new Email(request.getEmail());
        String passwordHash = passwordEncoder.encode(request.getPassword());

        User user = User.createNewUser(username, email, passwordHash);

        userRepository.save(user);
    }

//    public void register(RegisterUserRequest request) {
//        Username username = new Username(request.getUsername());
//        Email email = new Email(request.getEmail());
//
//        String hashedPassword = passwordEncoder.encode(request.getPassword());
//
//        User user = new User(
//                null,
//                username,
//                email,
//                hashedPassword,
//                Instant.now()
//        );
//
//        userRepository.save(user);
//    }
}
