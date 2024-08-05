package com.kajarta.repository;

import com.kajarta.demo.model.Car;
import com.kajarta.demo.model.Preference;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>, JpaSpecificationExecutor<Car> {
    List<Car> findByCreateTimeAfter(LocalDateTime since);

    Car findTopByOrderByCreateTimeDesc();

    

    @Query(value = "SELECT * FROM Car WHERE customer_id= :Id", nativeQuery = true)
    List<Car> findByCustomerId(Integer Id); // 搜尋會員心儀清單
}
