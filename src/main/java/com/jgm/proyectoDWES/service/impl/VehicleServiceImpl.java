package com.jgm.proyectoDWES.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jgm.proyectoDWES.entities.Vehicle;
import com.jgm.proyectoDWES.entities.VehicleType;
import com.jgm.proyectoDWES.error.exception.PeliculaNotFoundException;
import com.jgm.proyectoDWES.repository.VehicleRepository;
import com.jgm.proyectoDWES.service.VehicleService;

import jakarta.validation.Valid;

public class VehicleServiceImpl implements VehicleService{
	@Autowired
	private VehicleRepository veRep;
	
	@Override
	public Vehicle addVehicle(Vehicle pelicula) {
		return veRep.save(pelicula);
	}
	
	@Override
	public Page<Vehicle> listAllVehicles(Pageable pageable) {
		return veRep.findAll(pageable);
	}
	
	@Override
	public Vehicle getVehicleById(Long id) {
		return veRep.findById(id)
	            .orElseThrow(() -> new PeliculaNotFoundException("Pelicula no encontrada"));
	}
	
	@Override
	public Vehicle updateVehicle(Long id, Vehicle pelicula) {
		Vehicle newVehicle = getVehicleById(id);
		newVehicle.setBrand(pelicula.getBrand());
		newVehicle.setModel(pelicula.getModel());
		newVehicle.setVehicleType(pelicula.getVehicleType());
		newVehicle.setProductionDate(pelicula.getProductionDate());
		newVehicle.setEngine(pelicula.getEngine());
		
		
	    return veRep.save(pelicula);
	}
	
	@Override
	public void deleteVehicle(Long id) {
		veRep.deleteById(id);
		
	}	
}



