package com.jgm.proyectoDWES.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Engine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String engine_type;
	private String fuel_type;
	private String cylinders;
	private Integer horsepower;
	private String transmission;
	
	@OneToMany(mappedBy = "engine")
	private Set<Vehicle> vehicles;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEngine_type() {
		return engine_type;
	}
	public void setEngine_type(String engine_type) {
		this.engine_type = engine_type;
	}
	public String getFuel_type() {
		return fuel_type;
	}
	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}

	public Integer getHorsepower() {
		return horsepower;
	}
	public void setHorsepower(Integer horsepower) {
		this.horsepower = horsepower;
	}

	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	
	
}
