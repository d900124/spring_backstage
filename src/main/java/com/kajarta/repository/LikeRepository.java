package com.kajarta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kajarta.demo.model.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Integer> {

}
