package com.jgm.proyectoDWES.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jgm.proyectoDWES.dto.response.user.UserResponse;

public interface UserService {
    UserDetailsService userDetailsService();
    List<UserResponse> getAllUsers();
}
