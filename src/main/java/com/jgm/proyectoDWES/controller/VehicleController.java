package com.jgm.proyectoDWES.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jgm.proyectoDWES.entities.Vehicle;
import com.jgm.proyectoDWES.service.VehicleService;

import jakarta.persistence.EntityNotFoundException;


	@RestController
	@RequestMapping("/api/v1/vehicles")
	public class VehicleController {

    	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

	    @Autowired
	    private VehicleService veSer;

	    // Endpoint para obtener un listado de libros, accesible solo por ROLE_USER
	    @GetMapping
	    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
	    public ResponseEntity<Page<Vehicle>> listarTodosLosLibros(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        
	        logger.info("LibrosController :: listarTodosLosLibros");
	        Pageable pageable = PageRequest.of(page, size);
	        Page<Vehicle> vehicles = veSer.listAllVehicles(pageable);
	        
	   
	        
	        return new ResponseEntity<>(vehicles, HttpStatus.OK);
	    }
	    
	    @GetMapping("/{id}")
	    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
	    public Vehicle getVehicleById(@PathVariable Long id) {
	        return veSer.getVehicleById(id);
	    }

	    @PostMapping
	    @PreAuthorize("hasRole('ROLE_ADMIN')")
	    public Vehicle addVehicle(@RequestBody Vehicle book) {
	        return veSer.addVehicle(book);
	    }

	    @PutMapping("/{id}")
	    @PreAuthorize("hasRole('ROLE_ADMIN')")
	    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle bookDetails) {
	        return veSer.updateVehicle(id, bookDetails);
	    }


	    @DeleteMapping("/{id}")
	    @PreAuthorize("hasRole('ROLE_ADMIN')")
	    public void deleteVehicle(@PathVariable Long id) {
	    	veSer.deleteVehicle(id);
	    }

}
	    
	    
	    
	