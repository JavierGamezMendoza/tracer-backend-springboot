package com.jgm.proyectoDWES.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jgm.proyectoDWES.entities.Pelicula;
import com.jgm.proyectoDWES.error.exception.PeliculaNotFoundException;
import com.jgm.proyectoDWES.repository.PeliculaRepository;
import com.jgm.proyectoDWES.service.PeliculaService;

import jakarta.validation.Valid;

public class PeliculaServiceImpl implements PeliculaService{
	@Autowired
	private PeliculaRepository peRep;
	
	@Override
	public Pelicula agregarPelicula(Pelicula pelicula) {
		return peRep.save(pelicula);
	}
	
	@Override
	public Page<Pelicula> listarTodasLasPeliculas(Pageable pageable) {
		return peRep.findAll(pageable);
	}
	
	@Override
	public Pelicula obtenerPeliculaPorId(Long id) {
		return peRep.findById(id)
	            .orElseThrow(() -> new PeliculaNotFoundException("Pelicula no encontrada"));
	}
	
	@Override
	public Pelicula actualizarPelicula(Long id, Pelicula pelicula) {
		Pelicula peliculaO = obtenerPeliculaPorId(id);
		peliculaO.setTitle(pelicula.getTitle());
		peliculaO.setSipnosis(pelicula.getSipnosis());
		peliculaO.setDirector(pelicula.getDirector());
		peliculaO.setReleaseDate(pelicula.getReleaseDate());

	    return peRep.save(pelicula);
	}
	
	@Override
	public void eliminarPelicula(Long id) {
		peRep.deleteById(id);
		
	}	
}



