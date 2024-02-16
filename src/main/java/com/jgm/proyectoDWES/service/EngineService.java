package com.jgm.proyectoDWES.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jgm.proyectoDWES.entities.Engine;

public interface EngineService {

	Engine addEngine(Engine brand);
	Page <Engine> listAllEngines(Pageable pageable);
	Engine getEngineById(Long id);
	Engine updateEngine(Long id, Engine brand);
	
	void deleteEngine(Long id);
}
