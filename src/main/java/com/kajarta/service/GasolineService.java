package com.kajarta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kajarta.demo.model.Gasoline;
import com.kajarta.repository.GasolineRepository;

@Service
public class GasolineService {

    @Autowired
    private GasolineRepository gasolineRepo;

    public Gasoline findById(Integer id) {
        Gasoline gasolineModel = gasolineRepo.findById(id).get();
        String gaso = gasolineRepo.findById(id).get().getGaso().trim();
        gasolineModel.setGaso(gaso);
        return gasolineModel;
    }
}
