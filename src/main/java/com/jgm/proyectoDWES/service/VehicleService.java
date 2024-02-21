package com.jgm.proyectoDWES.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jgm.proyectoDWES.entities.Vehicle;

public interface VehicleService {

    Vehicle addVehicle(Vehicle vehicle);

    Page<Vehicle> listAllVehicles(Pageable pageable);

    Vehicle getVehicleById(Long id);
    
    Vehicle getVehicleByModel(String model);

    Vehicle updateVehicle(Long id, Vehicle brand);

    void deleteVehicle(Long id);
   
}