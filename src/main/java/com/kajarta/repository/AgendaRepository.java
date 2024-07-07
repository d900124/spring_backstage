package com.kajarta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kajarta.demo.model.Agenda;


public interface AgendaRepository extends JpaRepository<Agenda, Integer> {

}
