package com.kajarta.service;

import com.kajarta.demo.model.Customer;
import com.kajarta.demo.vo.CustomerVO;
import org.springframework.data.domain.Page;

import java.util.List;
public interface CustomerService {
    // 計算數量
    long countCustomers();

    // 查詢全部
    List<CustomerVO> findAll();

    // 單筆查詢，依據用戶id查詢單一用戶資訊
    Customer findById(Integer customerId);

    // 依據用戶帳號查詢
    Customer getByUsername(String account);

    // 分頁多條件查詢
    Page<CustomerVO> findByConditionsWithPagination(CustomerVO customerVO);

    // 新增
    CustomerVO create(CustomerVO customerVO);

    // 修改
    CustomerVO modify(CustomerVO customerVO);



}
