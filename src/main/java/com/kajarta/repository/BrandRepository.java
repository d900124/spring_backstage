package com.kajarta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kajarta.demo.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
