package com.zaur.user_service.security;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AuthenticatedUser {
    UUID id;
    String username;
    String role;
}

