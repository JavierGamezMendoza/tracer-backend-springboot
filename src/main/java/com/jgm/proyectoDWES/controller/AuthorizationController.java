package com.jgm.proyectoDWES.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jgm.proyectoDWES.dto.response.user.UserResponse;
import com.jgm.proyectoDWES.entities.User;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/resources")
@RequiredArgsConstructor
@CrossOrigin // Esto permite el acceso CORS de cualquier origen a todos los endpoints en este controlador
public class AuthorizationController {
	private static final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);

	
    @GetMapping
    public ResponseEntity<String> sayHello() {
    	logger.info("## AuthorizationController :: sayHello" );
        return ResponseEntity.ok("Here is your resource");
    }
    
    @GetMapping("/perfil")
    public ResponseEntity<UserResponse> miPerfil(@AuthenticationPrincipal User usuario) {
    	logger.info("## AuthorizationController :: miPerfil" );
    	
    	UserResponse userResponse = new UserResponse(usuario.getFirstName(), usuario.getLastName(), usuario.getEmail(), usuario.getRoles().toString());
    	
    	return  ResponseEntity.ok(userResponse);
    }
    

}
