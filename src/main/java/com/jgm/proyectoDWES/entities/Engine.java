package com.jgm.proyectoDWES.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Engine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Engine denomination can't be blank")
	private String denomination;
	@NotBlank(message="Engine fuel type can't be blank")
	private String fuelType;
	@NotBlank(message="Engine cylinders can't be blank")
	private String cylinders;
	@NotBlank(message="Engine horsepower can't be blank")
	private String horsepower;
	@NotBlank(message="Engine transmission can't be blank")
	private String transmission;
	
	
	@OneToMany(mappedBy = "engine")
	private Set<Vehicle> vehicles;
	
}
