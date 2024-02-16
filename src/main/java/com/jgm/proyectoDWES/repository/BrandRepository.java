package com.jgm.proyectoDWES.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jgm.proyectoDWES.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{

}
