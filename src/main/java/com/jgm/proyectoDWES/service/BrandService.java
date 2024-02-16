package com.jgm.proyectoDWES.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jgm.proyectoDWES.entities.Brand;

public interface BrandService {
	Brand addBrand(Brand brand);
	Page <Brand> listAllBrands(Pageable pageable);
	Brand getBrandById(Long id);
	Brand updateBrand(Long id, Brand brand);
	
	void deleteBrand(Long id);
}