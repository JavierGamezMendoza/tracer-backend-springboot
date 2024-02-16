package com.jgm.proyectoDWES.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

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
    	
    	Brand brand = new Brand();
    	brand.setName("Ferrari");
    	brand.setCompany("Fiat");
    	brand.setCountry("Italy");
    	
    	brandRepository.save(brand);
    	
    	Engine engine = new Engine();
    	engine.setEngine_denomination("Twin-turbocharged 2.9L");
    	engine.setCylinders("V8");
    	engine.setFuel_type("gas");
    	engine.setHorsepower("471 hp @ 7,000 rpm");
    	engine.setTransmission("manual");
    	
    	engineRepository.save(engine);
    	
    	Vehicle vehicle = new Vehicle();
    	vehicle.setBrand(brand);
    	vehicle.setEngine(engine);
    	vehicle.setModel("F40");
    	vehicle.setProductionDate(1987);
    	
    	vehicleRepository.save(vehicle);
    	
    	
    }
}
