package com.jgm.proyectoDWES.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.jgm.proyectoDWES.entities.Role;
import com.jgm.proyectoDWES.entities.Vehicle;
import com.jgm.proyectoDWES.repository.VehicleRepository;


@Profile("demo")
@Component
public class InitializationData implements CommandLineRunner{

	
    
    private final boolean deleteAllVehicles = false; 
    
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public void run(String... args) throws Exception {
    	
    	if (deleteAllVehicles) {
            vehicleRepository.deleteAll(); // Borra todos los libros existentes
        }
    	

    	Faker faker = new Faker(new Locale("es"));
        for (int i = 0; i < 10; i++) {
        	
        	Vehicle vehicle = new Vehicle();
        	
        	vehicle.setBrand(faker.options().option());
            vehicle.setModel(faker.options().option("Camry", "Corolla", "Accord", "Civic", "F-150", "Silverado", "3 Series", "C-Class"));
            vehicle.setProductionDate(faker.number().numberBetween(1980, 2024));
  
            vehicleRepository.save(vehicle);
        }
        
    }
}
