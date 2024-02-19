package com.jgm.proyectoDWES.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jgm.proyectoDWES.entities.Brand;
import com.jgm.proyectoDWES.service.BrandService;

@RestController
@RequestMapping("/api/v1/brands")
@CrossOrigin(origins= "*")
public class BrandController {

	@Autowired
	private BrandService brandSer;

	
	@GetMapping
	public ResponseEntity<Page<Brand>> listAllBrands(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {

		// logger.info("LibrosController :: listarTodosLosLibros");
		Pageable pageable = PageRequest.of(page, size);
		Page<Brand> brands = brandSer.listAllBrands(pageable);

		return new ResponseEntity<>(brands, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Brand getBrandById(@PathVariable Long id) {
		return brandSer.getBrandById(id);
	}

	@PostMapping
	public Brand addBrand(@RequestBody Brand brand) {
		return brandSer.addBrand(brand);
	}

	@PutMapping("/{id}")
	public Brand updateBrand(@PathVariable Long id, @RequestBody Brand brandDetails) {
		return brandSer.updateBrand(id, brandDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteBrand(@PathVariable Long id) {
		brandSer.deleteBrand(id);
	}

}