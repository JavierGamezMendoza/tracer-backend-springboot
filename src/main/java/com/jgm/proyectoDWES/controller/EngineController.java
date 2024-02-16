package com.jgm.proyectoDWES.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jgm.proyectoDWES.entities.Engine;
import com.jgm.proyectoDWES.entities.Vehicle;
import com.jgm.proyectoDWES.service.EngineService;
import com.jgm.proyectoDWES.service.VehicleService;

@RestController
@RequestMapping("/api/v1/engines")
public class EngineController {

	@Autowired
	private EngineService engineSer;

	// Endpoint para obtener un listado de libros, accesible solo por ROLE_USER
	@GetMapping
	public ResponseEntity<Page<Engine>> listAllEngines(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {

		// logger.info("LibrosController :: listarTodosLosLibros");
		Pageable pageable = PageRequest.of(page, size);
		Page<Engine> vehicles = engineSer.listAllEngines(pageable);

		return new ResponseEntity<>(vehicles, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Engine getEngineById(@PathVariable Long id) {
		return engineSer.getEngineById(id);
	}

	@PostMapping
	public Engine addEngine(@RequestBody Engine engine) {
		return engineSer.addEngine(engine);
	}

	@PutMapping("/{id}")
	public Engine updateEngine(@PathVariable Long id, @RequestBody Engine engineDetails) {
		return engineSer.updateEngine(id, engineDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteEngine(@PathVariable Long id) {
		engineSer.deleteEngine(id);
	}

}