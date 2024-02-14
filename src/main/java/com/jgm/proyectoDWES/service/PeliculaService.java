package com.jgm.proyectoDWES.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jgm.proyectoDWES.entities.Pelicula;

public interface PeliculaService {

    Pelicula agregarPelicula(Pelicula pelicula);

    Page<Pelicula> listarTodasLasPeliculas(Pageable pageable);

    Pelicula obtenerPeliculaPorId(Long id);

    Pelicula actualizarPelicula(Long id, Pelicula pelicula);

    void eliminarPelicula(Long id);
   
}