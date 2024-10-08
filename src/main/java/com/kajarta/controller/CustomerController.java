package com.kajarta.controller;

import com.kajarta.demo.domian.Result;
import com.kajarta.demo.domian.ResultNew;
import com.kajarta.demo.enums.AccountTypeEnum;
import com.kajarta.demo.enums.CityEnum;
import com.kajarta.demo.model.Customer;
import com.kajarta.demo.utils.ResultUtil;
import com.kajarta.demo.vo.CustomerVO;
import com.kajarta.demo.vo.EmployeeVO;
import com.kajarta.service.CustomerService;
import com.kajarta.util.DatetimeConverter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Tag(name = "管理後台-會員")
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customer")
public class CustomerController extends BaseController {
    @Autowired
    private CustomerService customerService;

    @Operation(summary = "統計會員數量")
    @GetMapping("/count")
    public Result<Long> countCustomers() {
        long count = customerService.countCustomers();
        return ResultUtil.success(count);
    }

    @Operation(summary = "會員資訊-查詢全部")
    @GetMapping("/all")
    public Result<List<CustomerVO>> findAll() {
        // todo:依據token獲取後台登入用戶

        log.info("{}-後台查詢客戶資訊-全部", "到時候換成上一步拿到的管理員");
        List<CustomerVO> customerVOList;
        try {
            customerVOList = customerService.findAll();
        } catch (Exception e) {
            return ResultUtil.error("查詢出錯");
        }
        return ResultUtil.success(customerVOList);
    }


    @Operation(summary = "會員資訊-依多條件查詢(分頁)")
    @PostMapping("/query")
    public ResultNew<Page<CustomerVO>> queryCustomer(@RequestBody CustomerVO customerVO, HttpServletRequest request) {

        log.info("{}-後台查詢客戶資訊-多條件查詢(分頁)", "到時候換成上一步拿到的管理員");
        Page<CustomerVO> customerPage = customerService.findByConditionsWithPagination(customerVO);

        ResultNew<Page<CustomerVO>> result =  new ResultNew<>();
        result.setCode(200);
        result.setMsg("查詢成功");
        result.setData(customerPage);
        result.setSuccess(true);
        return result;

    }


    @Operation(summary = "會員資訊-依據會員id查詢單筆")
    @PostMapping(value = "/info2")
    public Result<CustomerVO> info2(@Parameter(description = "會員id") Integer customerId) {
        // todo:依據token獲取後台登入用戶


        log.info("{}-後台查詢客戶資訊-單筆：{}", "到時候換成上一步拿到的管理員", customerId);
        CustomerVO customerVO;
        try {
            Customer customer = customerService.findById(customerId);
            customerVO = new CustomerVO();
            BeanUtils.copyProperties(customer, customerVO);
            customerVO.setCreateTime(DatetimeConverter.toString(new Date(customer.getCreateTime().getTime()), DatetimeConverter.YYYY_MM_DD_HH_MM_SS));
            customerVO.setUpdateTime(DatetimeConverter.toString(new Date(customer.getUpdateTime().getTime()), DatetimeConverter.YYYY_MM_DD_HH_MM_SS));
        } catch (Exception e) {
            return ResultUtil.error("查詢出錯");
        }

        return ResultUtil.success(customerVO);
    }

    @Operation(summary = "會員資訊-依據會員id查詢單筆")
    @GetMapping("/info/{customerId}")
    public Result<CustomerVO> info(@Parameter(description = "會員id") @PathVariable Integer customerId) {
        // todo:依據token獲取後台登入用戶
        System.out.println("id="+getAdminId());
        System.out.println("name="+getAdmin());
        log.info("{}-後台查詢客戶資訊-單筆：{}", getAdmin(), customerId);
        CustomerVO customerVO;
        try {
            Customer customer = customerService.findById(customerId);
            customerVO = new CustomerVO();
            BeanUtils.copyProperties(customer, customerVO);
            customerVO.setAccountTypeName(AccountTypeEnum.getByCode(customer.getAccountType()).getAccountType());
            customerVO.setCityName(CityEnum.getByCode(customer.getCity()).getCity());
            customerVO.setCreateTime(DatetimeConverter.toString(new Date(customer.getCreateTime().getTime()), DatetimeConverter.YYYY_MM_DD_HH_MM));
            customerVO.setUpdateTime(DatetimeConverter.toString(new Date(customer.getUpdateTime().getTime()), DatetimeConverter.YYYY_MM_DD_HH_MM));
        } catch (Exception e) {
            return ResultUtil.error("查詢出錯");
        }

        return ResultUtil.success(customerVO);
    }


    @Operation(summary = "會員資訊-新增會員")
    @PostMapping(value = "/add")
    public Result<CustomerVO> addCustomer(@RequestBody CustomerVO customerVO) {
        // todo:依據token獲取後台登入用戶


        log.info("{}-新增客戶資訊：{}", "到時候換成上一步拿到的管理員", customerVO.toString());
        try {
            customerVO = customerService.create(customerVO);
        } catch (Exception e) {
            return ResultUtil.error("新增用戶出錯");
        }
        return ResultUtil.success(customerVO);
    }

    @Operation(summary = "會員資訊-修改會員")
    @PutMapping(value = "/modify/{customerId}")
    public Result<CustomerVO> modifyCustomer(
            @Parameter(description = "會員id") @PathVariable Integer customerId,
            @RequestBody CustomerVO customerVO) {
        // todo:依據token獲取後台登入用戶

        log.info("{}-修改客戶資訊：{}", "到時候換成上一步拿到的管理員", customerVO.toString());
        customerVO.setId(customerId); // 確保傳入的客戶資料有正確的ID
        try {
            CustomerVO updatedCustomer = customerService.modify(customerVO);
            if (updatedCustomer == null) {
                return ResultUtil.error("找不到會員ID: " + customerId);
            }
            return ResultUtil.success(updatedCustomer);
        } catch (Exception e) {
            return ResultUtil.error("修改用戶出錯");
        }
    }


}
