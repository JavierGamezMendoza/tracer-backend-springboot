package com.jgm.proyectoDWES.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jgm.proyectoDWES.entities.Brand;
import com.jgm.proyectoDWES.error.exception.VehicleNotFoundException;
import com.jgm.proyectoDWES.repository.BrandRepository;
import com.jgm.proyectoDWES.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public Brand addBrand(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public Page<Brand> listAllBrands(Pageable pageable) {
		return brandRepository.findAll(pageable);
	}

	@Override
	public Brand getBrandById(Long id) {
		return brandRepository.findById(id)
	            .orElseThrow(() -> new VehicleNotFoundException("Brand doesn't exists"));
	}

	@Override
	public Brand updateBrand(Long id, Brand brand) {
		Brand newBrand = getBrandById(id);
		newBrand.setName(brand.getName());
		newBrand.setCountry(brand.getCountry());
		newBrand.setCompany(brand.getCompany());
		
	    return brandRepository.save(newBrand); 
	}

	@Override
	public void deleteBrand(Long id) {
		brandRepository.deleteById(id);
	}

}
