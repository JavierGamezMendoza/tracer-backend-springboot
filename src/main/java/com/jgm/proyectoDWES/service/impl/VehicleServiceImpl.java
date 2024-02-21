package com.jgm.proyectoDWES.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jgm.proyectoDWES.entities.Vehicle;
import com.jgm.proyectoDWES.error.exception.VehicleNotFoundException;
import com.jgm.proyectoDWES.repository.VehicleRepository;
import com.jgm.proyectoDWES.service.VehicleService;

import jakarta.validation.Valid;

@Service
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
	            .orElseThrow(() -> new VehicleNotFoundException("Pelicula no encontrada"));
	}
	
	@Override
	public Vehicle updateVehicle(Long id, Vehicle vehicle) {
		Vehicle newVehicle = getVehicleById(id);
		newVehicle.setBrand(vehicle.getBrand());
		newVehicle.setModel(vehicle.getModel());
		newVehicle.setProductionDate(vehicle.getProductionDate());
		newVehicle.setEngine(vehicle.getEngine());
		
		
	    return veRep.save(vehicle);
	}
	
	@Override
	public void deleteVehicle(Long id) {
		veRep.deleteById(id);
		
	}

	@Override
	public Vehicle getVehicleByModel(String model) {
		return veRep.findByModel(model);
	}	
}



