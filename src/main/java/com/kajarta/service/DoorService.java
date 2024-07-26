package com.kajarta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kajarta.demo.model.Door;
import com.kajarta.repository.DoorRepository;

@Service
public class DoorService {

    @Autowired
    private DoorRepository doorRepo;

    public Door findById(Integer id) {
        return doorRepo.findById(id).get();
    }
}
