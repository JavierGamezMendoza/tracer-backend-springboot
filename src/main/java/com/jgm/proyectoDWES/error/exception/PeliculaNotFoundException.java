package com.jgm.proyectoDWES.error.exception;

public class PeliculaNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public PeliculaNotFoundException(String message) {
        super(message);
    }
}