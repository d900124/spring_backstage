package com.kajarta.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kajarta.demo.domian.Result;
import com.kajarta.demo.model.CustomerRecord;
import com.kajarta.demo.utils.ResultUtil;
import com.kajarta.demo.vo.CustomerRecordVO;
import com.kajarta.service.CustomerRecordService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "前台-客戶紀錄")
@Slf4j
@Validated
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customerRecord")
public class CustomerRecordController {

    @Autowired
    private CustomerRecordService customerRecordService;

    @Operation(summary = "客戶紀錄-依據customer id查詢單筆")
    @GetMapping("/{id}")
    public Result<CustomerRecordVO> info(@Parameter(description = "customer id") @PathVariable Integer id) {
        // todo:依據customer id獲取紀錄

        log.info("{}-依據customer id查詢客戶紀錄-單筆：{}", "到時候換成上一步拿到的管理員", id);
        CustomerRecordVO customerRecordVO;
        try {
            CustomerRecord customerRecord = customerRecordService.findById(id);

            customerRecordVO = customerRecordService.vOChange(customerRecord);
        } catch (Exception e) {
            return ResultUtil.error("查詢出錯");
        }

        return ResultUtil.success(customerRecordVO);
    }

    // 新增一筆
    @Operation(summary = "客戶紀錄-新增一筆 / 檢查customer id 是否有建過")
    @PostMapping("")
    public String create(@Parameter(description = "新增客戶紀錄") @RequestBody String body) {
        JSONObject responseBody = new JSONObject();
        JSONObject obj = new JSONObject(body);
        Integer customerId = obj.isNull("customerId") ? null : obj.getInt("customerId");
        if (customerId != null) {
            CustomerRecord check = customerRecordService.findById(customerId);
            if (check == null) {
                CustomerRecord customerRecord = customerRecordService.create(body);
                if (customerRecord == null) {
                    responseBody.put("success", false);
                    responseBody.put("message", "CustomerRecord新增失敗(串接問題)");
                } else {
                    responseBody.put("success", true);
                    responseBody.put("message", "CustomerRecord新增成功");
                }
            } else {
                responseBody.put("success", false);
                responseBody.put("message", "CustomerRecord新增失敗(ID已有紀錄)");
            }
        } else {
            responseBody.put("success", false);
            responseBody.put("message", "CustomerRecord新增失敗(沒有customer ID)");
        }
        return responseBody.toString();

    }
}
