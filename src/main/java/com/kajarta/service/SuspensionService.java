package com.kajarta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kajarta.demo.model.Suspension;
import com.kajarta.repository.SuspensionRepository;

@Service
public class SuspensionService {

    @Autowired
    private SuspensionRepository suspensionRepo;

    public Suspension findById(Integer id) {
        return suspensionRepo.findById(id).get();
    }
}
