package com.jgm.proyectoDWES.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Vehicle {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "brand_id")
	@NotNull(message="Vehicle brand can't be null")
	private Brand brand;
	@NotBlank(message="Vehicle model can't be blank")
	@NotNull(message="Vehicle model can't be null")
    private String model;
	@NotNull(message="Vehicle production date can't be null")
    private Integer productionDate;
    @ManyToOne
    @JoinColumn(name = "engine_id")
	private Engine engine;
    
    
}
