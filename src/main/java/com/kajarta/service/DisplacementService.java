package com.kajarta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kajarta.demo.model.Displacement;
import com.kajarta.repository.DisplacementRepository;

@Service
public class DisplacementService {

    @Autowired
    private DisplacementRepository displacementRepo;

    public Displacement findById(Integer id) {
        return displacementRepo.findById(id).get();
    }
}
