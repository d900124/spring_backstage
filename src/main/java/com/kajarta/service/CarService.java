package com.kajarta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kajarta.demo.model.Car;
import com.kajarta.repository.CarRepository;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepo;

    public List<Car> findAll(String json) {
        return carRepo.findAll();
    }

    public Optional<Car> findById(Integer Id) {
        Optional<Car> optional = carRepo.findById(Id);
        if (optional.isPresent()) {
            return optional;
        }
        return null;
    }

    public Car createOrModify(Car car) {
        return carRepo.save(car);
    }

    public void remove(Integer Id) {
        carRepo.deleteById(Id);
    }

    // public Car create(String json) {
    // try {
    // JSONObject obj = new JSONObject(json);
    // Integer ID = obj.isNull("id") ? null : obj.getInt("id");
    // Integer productionYear = obj.isNull("productionYear") ? null :
    // obj.getInt("productionYear");
    // Integer milage = obj.isNull("milage") ? null : obj.getInt("milage");
    // Integer customerId = obj.isNull("customerId") ? null :
    // obj.getInt("customerId");
    // Integer employeeId = obj.isNull("employeeId") ? null :
    // obj.getInt("employeeId");
    // Short negotiable = obj.isNull("negotiable") ? null : (short)
    // obj.getInt("negotiable");
    // Integer conditionScore = obj.isNull("conditionScore") ? null :
    // obj.getInt("conditionScore");
    // Short branch = obj.isNull("branch") ? null : (short) obj.getInt("branch");
    // Short state = obj.isNull("state") ? null : (short) obj.getInt("state");
    // BigDecimal price = obj.isNull("price") ? null : obj.getBigDecimal("price");
    // Instant launchDate = obj.isNull("launchDate") ? null :
    // Instant.parse(obj.getString("launchDate"));
    // Integer carinfoId = obj.isNull("carinfoId") ? null : obj.getInt("carinfoId");
    // String color = obj.isNull("color") ? null : obj.getString("color");
    // Short remark = obj.isNull("remark") ? null : (short) obj.getInt("remark");

    // Optional<Car> optional = carRepo.findById(ID);
    // if (optional.isEmpty()) {
    // Car car = new Car();
    // car.setId(ID);
    // car.setProductionYear(productionYear);
    // car.setMilage(milage);
    // car.setCustomer(null);
    // car.setEmployee(null);
    // car.setNegotiable(negotiable);
    // car.setConditionScore(conditionScore);
    // car.setBranch(branch);
    // car.setState(state);
    // car.setPrice(price);
    // car.setLaunchDate(launchDate);
    // car.setCarinfo(null);
    // car.setColor(color);
    // car.setRemark(remark);
    // return carRepo.save(car);
    // }
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // return null;
    // }

    // public findById(String json){

    // }
}
