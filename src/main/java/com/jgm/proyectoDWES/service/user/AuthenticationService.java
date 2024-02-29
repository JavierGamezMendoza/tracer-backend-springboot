package com.jgm.proyectoDWES.service.user;

import com.jgm.proyectoDWES.dto.request.SignUpRequest;
import com.jgm.proyectoDWES.dto.request.SigninRequest;
import com.jgm.proyectoDWES.dto.response.user.JwtAuthenticationResponse;

public interface AuthenticationService {
	
	/** REGISTRO */
    JwtAuthenticationResponse signup(SignUpRequest request);
    /** ACCESO a Token JWT */
    JwtAuthenticationResponse signin(SigninRequest request);
}
