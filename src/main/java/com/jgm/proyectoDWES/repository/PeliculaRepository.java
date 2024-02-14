package com.jgm.proyectoDWES.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jgm.proyectoDWES.entities.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

}
