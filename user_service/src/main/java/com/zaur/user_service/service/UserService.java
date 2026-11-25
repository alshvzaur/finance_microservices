package com.zaur.user_service.service;

import com.zaur.user_service.dto.AuthResponse;
import com.zaur.user_service.dto.LoginRequest;
import com.zaur.user_service.dto.RegisterRequest;
import com.zaur.user_service.exception.UserAlreadyExistsException;
import com.zaur.user_service.model.Role;
import com.zaur.user_service.model.User;
import com.zaur.user_service.repository.UserRepository;
import com.zaur.user_service.security.JwtUtil;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    JwtUtil jwtUtil;
    AuthenticationManager authenticationManager;

    public AuthResponse saveUser(RegisterRequest registerRequest) {

        if (userRepository.existsByEmail(registerRequest.getEmail()) || userRepository.existsByUsername(registerRequest.getUsername())){
            throw new UserAlreadyExistsException("User Already Exists");
        }

        User user = User.builder()
                .username(registerRequest.getUsername())
                .name(registerRequest.getName())
                .surname(registerRequest.getSurname())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();


        User registeredUser = userRepository.save(user);

        return new AuthResponse(jwtUtil.generateToken(registeredUser.getUsername(),
                registeredUser.getId().toString(),
                registeredUser.getRole().name()));
    }

    public AuthResponse login(@Valid LoginRequest loginRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        ));

        User user = findUserByUsername(loginRequest.getUsername());
        AuthResponse authResponse = new AuthResponse(jwtUtil.generateToken(user.getUsername(),
               user.getId().toString(),
                user.getRole().name()));

        return authResponse;
    }

    public User findUserByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }

}
