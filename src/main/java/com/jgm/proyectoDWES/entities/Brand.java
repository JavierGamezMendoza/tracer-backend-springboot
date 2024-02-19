package com.jgm.proyectoDWES.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Brand name can't be blank")
	@Column(unique = true)
	private String name;
	@NotBlank(message="Brand country can't be blank")
	private String country;
	@NotBlank(message="Brand company can't be blank")
	private String company;
	
}
