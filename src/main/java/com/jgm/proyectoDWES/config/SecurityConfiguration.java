package com.jgm.proyectoDWES.config;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.jgm.proyectoDWES.entities.Role;
import com.jgm.proyectoDWES.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;
	@Autowired
     UserService userService;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request ->           
                request

                .requestMatchers("/api/v1/auth/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/v1/vehicles/**").hasAnyAuthority(Role.ROLE_USER.toString(), Role.ROLE_ADMIN.toString())
                .requestMatchers(HttpMethod.GET, "/api/v1/engines/**").hasAnyAuthority(Role.ROLE_USER.toString(), Role.ROLE_ADMIN.toString())
                .requestMatchers(HttpMethod.GET, "/api/v1/brands/**").hasAnyAuthority(Role.ROLE_USER.toString(), Role.ROLE_ADMIN.toString())
                .requestMatchers(HttpMethod.GET, "/api/v1/vehicles/model/**").hasAnyAuthority(Role.ROLE_USER.toString(), Role.ROLE_ADMIN.toString())
                .requestMatchers(HttpMethod.POST, "/api/v1/vehicles/**").hasAuthority(Role.ROLE_ADMIN.toString())
                .requestMatchers(HttpMethod.POST, "/api/v1/engines/**").hasAuthority(Role.ROLE_ADMIN.toString())
                .requestMatchers(HttpMethod.POST, "/api/v1/brands/**").hasAuthority(Role.ROLE_ADMIN.toString())
                .requestMatchers(HttpMethod.PUT, "/api/v1/vehicles/**").hasAuthority(Role.ROLE_ADMIN.toString())
                .requestMatchers(HttpMethod.PUT, "/api/v1/engines/**").hasAuthority(Role.ROLE_ADMIN.toString())
                .requestMatchers(HttpMethod.PUT, "/api/v1/brands/**").hasAuthority(Role.ROLE_ADMIN.toString())
 	            
 	          
 	            .requestMatchers(HttpMethod.DELETE, "/api/v1/vehicles/**").hasAuthority(Role.ROLE_ADMIN.toString())
 	            .requestMatchers(HttpMethod.DELETE, "/api/v1/engines/**").hasAuthority(Role.ROLE_ADMIN.toString())
 	            .requestMatchers(HttpMethod.DELETE, "/api/v1/brands/**").hasAuthority(Role.ROLE_ADMIN.toString())
 	           	.requestMatchers("/api/v1/users/**").hasAuthority("ROLE_ADMIN")  // Modificado aquí
                .anyRequest().authenticated())
                .sessionManagement(manager -> manager.sessionCreationPolicy(STATELESS))
                .cors(Customizer.withDefaults()) // Configure CORS here with Customizer
                .authenticationProvider(authenticationProvider()).addFilterBefore(
                        jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService.userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
    
   
}
