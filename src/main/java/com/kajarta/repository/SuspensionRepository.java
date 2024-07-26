package com.kajarta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kajarta.demo.model.Suspension;

@Repository
public interface SuspensionRepository extends JpaRepository<Suspension, Integer> {

}
