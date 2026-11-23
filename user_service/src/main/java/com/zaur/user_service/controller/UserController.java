package com.zaur.user_service.controller;

import com.zaur.user_service.dto.AuthResponse;
import com.zaur.user_service.dto.LoginRequest;
import com.zaur.user_service.dto.RegisterRequest;
import com.zaur.user_service.execption.UserAlreadyExistsException;
import com.zaur.user_service.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    @PostMapping("/register")
    public AuthResponse register(RegisterRequest registerRequest) throws UserAlreadyExistsException {
        return userService.saveUser(registerRequest);
    }

    @PostMapping("/login")
    public AuthResponse login(LoginRequest loginRequest){
        return userService.login(loginRequest);
    }

}
