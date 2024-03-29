package com.jgm.proyectoDWES.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jgm.proyectoDWES.entities.Engine;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Long>{

}
