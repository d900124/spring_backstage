package com.kajarta.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kajarta.demo.model.Car;
import com.spring_kajarta_frontstage.service.CarService;

@RestController
@RequestMapping("/kajarta")
@CrossOrigin
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/car/find/{Id}")
    public String findDataById(@PathVariable(name = "Id") Integer Id) {
        JSONObject responseBody = new JSONObject();
        JSONArray array = new JSONArray();
        Car car = carService.findById(Id).get();
        if (car != null) {
            JSONObject item = new JSONObject()
                    .put("id", car.getId())
                    .put("productionYear", car.getProductionYear())
                    .put("milage", car.getMilage())
                    .put("customerId", car.getCustomer())
                    .put("employeeId", car.getEmployee())
                    .put("negotiable", car.getNegotiable())
                    .put("conditionScore", car.getConditionScore())
                    .put("branch", car.getBranch())
                    .put("state", car.getState())
                    .put("price", car.getPrice())
                    .put("launchDate", car.getLaunchDate())
                    .put("carinfoId", car.getCarinfo())
                    .put("color", car.getColor())
                    .put("remark", car.getRemark())
                    .put("createTime", car.getCreateTime())
                    .put("updateTime", car.getUpdateTime());
            array = array.put(item);
        }
        responseBody.put("list", array);
        return responseBody.toString();
    }

    // @PostMapping("/car/insert")
    // public String insertData(@RequestBody String body) {
    // JSONObject reponseBody = new JSONObject();
    // JSONObject obj = new JSONObject(body);
    // Integer id = obj.isNull("id") ? null : obj.getInt("id");
    // if (id == null) {
    // reponseBody.put("success", false);
    // reponseBody.put("message", "ID是必要欄位");
    // } else {
    // if (tdService.exists(id)) {
    // reponseBody.put("success", false);
    // reponseBody.put("message", "ID已存在");
    // } else {
    // TpeData td = tdService.create(body);
    // if (td == null) {
    // reponseBody.put("success", false);
    // reponseBody.put("message", "新增失敗");
    // } else {
    // reponseBody.put("success", true);
    // reponseBody.put("message", "新增成功");

    // }
    // }
    // }
    // return reponseBody.toString();
    // }

    // @DeleteMapping("/car/remove/{id}")
    // public String removeData(@PathVariable(name = "id") Integer Id) {
    // JSONObject responseBody = new JSONObject();
    // if (Id == null) {
    // responseBody.put("success", false);
    // responseBody.put("message", "ID是必要欄位");
    // } else {
    // if (!tdService.exists(Id)) {
    // responseBody.put("success", false);
    // responseBody.put("message", "ID不存在");
    // } else {
    // if (!tdService.remove(Id)) {
    // responseBody.put("success", false);
    // responseBody.put("message", "刪除失敗");
    // } else {
    // responseBody.put("success", true);
    // responseBody.put("message", "刪除成功");

    // }
    // }
    // }
    // return responseBody.toString();
    // }

    // @PutMapping("car/update/{id}")
    // public String updateData(@PathVariable(name = "id") Integer id, @RequestBody
    // String body) {
    // JSONObject responseBody = new JSONObject();
    // if (id == null) {
    // responseBody.put("success", false);
    // responseBody.put("message", "ID是必要欄位");
    // } else {
    // if (!tdService.exists(id)) {
    // responseBody.put("success", false);
    // responseBody.put("message", "ID不存在");
    // } else {
    // TpeData td = tdService.update(body);
    // if (td == null) {
    // responseBody.put("success", false);
    // responseBody.put("message", "修改失敗");
    // } else {
    // responseBody.put("success", true);
    // responseBody.put("message", "修改成功");
    // }
    // }
    // }
    // return responseBody.toString();
    // }

}
