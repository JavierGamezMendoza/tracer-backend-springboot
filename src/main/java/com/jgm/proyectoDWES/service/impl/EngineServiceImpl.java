package com.jgm.proyectoDWES.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jgm.proyectoDWES.entities.Brand;
import com.jgm.proyectoDWES.entities.Engine;
import com.jgm.proyectoDWES.error.exception.VehicleNotFoundException;
import com.jgm.proyectoDWES.repository.EngineRepository;
import com.jgm.proyectoDWES.service.EngineService;

@Service
public class EngineServiceImpl implements EngineService{

	@Autowired
	private EngineRepository engineRepository;
	
	@Override
	public Engine addEngine(Engine brand) {
		return engineRepository.save(brand);
	}

	@Override
	public Page<Engine> listAllEngines(Pageable pageable) {
		return engineRepository.findAll(pageable);
	}

	@Override
	public Engine getEngineById(Long id) {
		return engineRepository.findById(id)
	            .orElseThrow(() -> new VehicleNotFoundException("Engine doesn't exists"));
	}

	@Override
	public Engine updateEngine(Long id, Engine engine) {
		Engine newEngine = getEngineById(id);
		newEngine.setDenomination(engine.getDenomination());
		newEngine.setFuelType(engine.getFuelType());
		newEngine.setHorsepower(engine.getHorsepower());
		newEngine.setTransmission(engine.getTransmission());
		
	    return engineRepository.save(newEngine); 
	}

	@Override
	public void deleteEngine(Long id) {

	}

}
