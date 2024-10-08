package com.kajarta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kajarta.demo.model.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

}
