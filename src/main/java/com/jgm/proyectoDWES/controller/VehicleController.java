package com.jgm.proyectoDWES.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@RestController
@RequestMapping("/api/v1/vehicles")
@CrossOrigin(origins= "*")
public class VehicleController {

	@Autowired
	private VehicleService veSer;

	// Endpoint para obtener un listado de libros, accesible solo por ROLE_USER
	@GetMapping
	public ResponseEntity<Page<Vehicle>> listAllVehicles(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {

		// logger.info("LibrosController :: listarTodosLosLibros");
		Pageable pageable = PageRequest.of(page, size);
		Page<Vehicle> vehicles = veSer.listAllVehicles(pageable);

		return new ResponseEntity<>(vehicles, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Vehicle getVehicleById(@PathVariable Long id) {
		return veSer.getVehicleById(id);
	}

	@PostMapping
	public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
		return veSer.addVehicle(vehicle);
	}

	@PutMapping("/{id}")
	public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicleDetails) {
		return veSer.updateVehicle(id, vehicleDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteVehicle(@PathVariable Long id) {
		veSer.deleteVehicle(id);
	}

}
