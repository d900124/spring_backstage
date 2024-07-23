package com.kajarta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kajarta.demo.model.Rearwheel;

@Repository
public interface RearWheelRepository extends JpaRepository<Rearwheel, Integer> {

}
