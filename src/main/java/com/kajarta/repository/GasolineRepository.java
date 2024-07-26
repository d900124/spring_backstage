package com.kajarta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kajarta.demo.model.Gasoline;

@Repository
public interface GasolineRepository extends JpaRepository<Gasoline, Integer> {

}
