package com.jgm.proyectoDWES.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jgm.proyectoDWES.entities.User;
import com.jgm.proyectoDWES.repository.UserRepository;
import com.github.javafaker.Faker;
import com.jgm.proyectoDWES.entities.Brand;
import com.jgm.proyectoDWES.entities.Engine;
import com.jgm.proyectoDWES.entities.Role;
import com.jgm.proyectoDWES.entities.Vehicle;
import com.jgm.proyectoDWES.repository.BrandRepository;
import com.jgm.proyectoDWES.repository.EngineRepository;
import com.jgm.proyectoDWES.repository.VehicleRepository;


@Profile("demo")
@Component
public class InitializationData implements CommandLineRunner{

	
    
    private final boolean deleteAllVehicles = false; 
    
    @Autowired
    private UserRepository usuarioRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private VehicleRepository vehicleRepository;
    
    @Autowired
    private BrandRepository brandRepository;
    
    @Autowired
    private EngineRepository engineRepository;
    
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
    	
    	Brand brand = new Brand();
    	brand.setName("ferrari");
    	brand.setCompany("fiat");
    	brand.setCountry("italy");	
    	brandRepository.save(brand);
    	
    	Brand brand1 = new Brand();
    	brand1.setName("audi");
    	brand1.setCompany("volkswagen");
    	brand1.setCountry("germany");	
    	brandRepository.save(brand1);
    	
    	Brand brand2 = new Brand();
    	brand2.setName("toyota");
    	brand2.setCompany("toyota");
    	brand2.setCountry("japan");	
    	brandRepository.save(brand2);
    	
    	Brand brand3 = new Brand();
    	brand3.setName("porsche");
    	brand3.setCompany("volkswagen");
    	brand3.setCountry("germany");	
    	brandRepository.save(brand3);
    	
    	Brand brand4 = new Brand();
    	brand4.setName("ford");
    	brand4.setCompany("ford");
    	brand4.setCountry("united-states");	
    	brandRepository.save(brand4);
    	
    	Engine engine = new Engine();
    	engine.setDenomination("twin-turbocharged 2.9L");
    	engine.setCylinders("V8");
    	engine.setFuelType("gas");
    	engine.setHorsepower("471 hp @ 7000 rpm");
    	engine.setTransmission("manual");
    	engineRepository.save(engine);
    	
    	Engine engine1 = new Engine();
    	engine1.setDenomination("1800 Turbocharged 1.8T");
    	engine1.setCylinders("I4");
    	engine1.setFuelType("gas");
    	engine1.setHorsepower("148 hp @ 6700 rpm");
    	engine1.setTransmission("manual");
    	engineRepository.save(engine1);
    	
    	Vehicle vehicle = new Vehicle();
    	vehicle.setBrand(brand);
    	vehicle.setEngine(engine);
    	vehicle.setModel("F40");
    	vehicle.setProductionDate(1987);
    	vehicleRepository.save(vehicle);
    	
    	Vehicle vehicle1 = new Vehicle();
    	vehicle1.setBrand(brand1);
    	vehicle1.setEngine(engine1);
    	vehicle1.setModel("A4 AEB");
    	vehicle1.setProductionDate(1998);
    	vehicleRepository.save(vehicle1);
    	
    	
    }
}
