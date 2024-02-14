package com.jgm.proyectoDWES.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.jgm.proyectoDWES.entities.Role;
import com.jgm.proyectoDWES.entities.User;
import com.jgm.proyectoDWES.entities.Vehicle;
import com.jgm.proyectoDWES.repository.UserRepository;
import com.jgm.proyectoDWES.repository.VehicleRepository;


@Profile("demo")
@Component
public class InitializationData implements CommandLineRunner{
	@Autowired
    private UserRepository usuarioRepository;
    
    private final boolean deleteAllVehicles = false; 
    
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
    	
    	if (deleteAllVehicles) {
            vehicleRepository.deleteAll(); // Borra todos los libros existentes
        }
    	
    	try {
    		// Usuario 1 - Rol USER
            User usuario1 = new User();
            usuario1.setFirstName("Alice");
            usuario1.setLastName("Johnson");
            usuario1.setEmail("alice.johnson@example.com");
            usuario1.setPassword(passwordEncoder.encode("password123"));
            usuario1.getRoles().add(Role.ROLE_USER);
            usuarioRepository.save(usuario1);

            // Usuario 2 - Rol ADMIN
            User usuario2 = new User();
            usuario2.setFirstName("Bob");
            usuario2.setLastName("Smith");
            usuario2.setEmail("bob.smith@example.com");
            usuario2.setPassword(passwordEncoder.encode("password456"));
            usuario2.getRoles().add(Role.ROLE_ADMIN);
            usuarioRepository.save(usuario2);

            // Usuario 3 - Rol USER
            User usuario3 = new User();
            usuario3.setFirstName("Carol");
            usuario3.setLastName("Davis");
            usuario3.setEmail("carol.davis@example.com");
            usuario3.setPassword(passwordEncoder.encode("password789"));
            usuario3.getRoles().add(Role.ROLE_USER);
            usuarioRepository.save(usuario3);
            
            
            
            
    	}catch(Exception e) {
    		
    	}
    	
    	Faker faker = new Faker(new Locale("es"));
        for (int i = 0; i < 10; i++) {
        	
        	Vehicle vehicle = new Vehicle();
        	
        	vehicle.setBrand(faker.options().option("Toyota", "Ford", "Honda", "Chevrolet", "BMW", "Mercedes-Benz"));
            vehicle.setModel(faker.options().option("Camry", "Corolla", "Accord", "Civic", "F-150", "Silverado", "3 Series", "C-Class"));
            vehicle.setProductionDate(faker.number().numberBetween(1980, 2024));
  
            vehicleRepository.save(vehicle);
        }
        
    }
}
