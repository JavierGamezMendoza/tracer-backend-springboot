package com.jgm.proyectoDWES.service.user.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jgm.proyectoDWES.dto.response.user.UserResponse;
import com.jgm.proyectoDWES.repository.UserRepository;
import com.jgm.proyectoDWES.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepository userRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
	@Override
	public List<UserResponse> getAllUsers() {
		List<UserResponse> allUsers =  userRepository.findAll().stream()
			    .map(usuario -> new UserResponse(usuario.getFirstName(), usuario.getLastName(), usuario.getEmail(), usuario.getRoles().toString()))
			    .collect(Collectors.toList());
		 return allUsers;
	}
}
