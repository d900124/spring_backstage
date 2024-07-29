package com.kajarta.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kajarta.demo.model.CustomerRecord;
import com.kajarta.demo.model.Employee;
import com.kajarta.demo.vo.CustomerRecordVO;
import com.kajarta.repository.CustomerRecordRepository;
import com.kajarta.util.DatetimeConverter;

@Service
public class CustomerRecordService {

    @Autowired
    private CustomerRecordRepository customerRecordRepo;

    // 查單筆
    public CustomerRecord findById(Integer id) {
        if (id != null) {
            Optional<CustomerRecord> optional = customerRecordRepo.findById(id);
            if (optional.isPresent()) {
                return optional.get();
            }
        }
        return null;
    }

    // 新增
    public CustomerRecord create(String json) {
        try {
            JSONObject obj = new JSONObject(json);
            Integer customerId = obj.isNull("customerId") ? null : obj.getInt("customerId");
            Date customerUpdateTime = obj.isNull("customerUpdateTime") ? new Date()
                    : DatetimeConverter.parse(obj.getString("customerUpdateTime"), "yyyy-MM-dd  HH:mm:ss");

            CustomerRecord insert = new CustomerRecord();
            insert.setCustomerId(customerId);
            insert.setCustomerIP("");
            insert.setCustomerUpdateTime(customerUpdateTime);

            // 記數
            insert.setCount(0);

            // 品牌
            insert.setBrandId01(0);
            insert.setBrandId02(0);
            insert.setBrandId03(0);
            insert.setBrandId04(0);
            insert.setBrandId05(0);
            insert.setBrandId06(0);
            insert.setBrandId07(0);
            insert.setBrandId08(0);
            insert.setBrandId09(0);

            // 排氣量
            insert.setDisplacementId01(0);
            insert.setDisplacementId02(0);
            insert.setDisplacementId03(0);
            insert.setDisplacementId04(0);
            insert.setDisplacementId05(0);
            insert.setDisplacementId06(0);
            insert.setDisplacementId07(0);

            // 門數
            insert.setDoorId01(0);
            insert.setDoorId02(0);
            insert.setDoorId03(0);
            insert.setDoorId04(0);
            insert.setDoorId05(0);

            // 乘客數
            insert.setPassengerId01(0);
            insert.setPassengerId02(0);
            insert.setPassengerId03(0);
            insert.setPassengerId04(0);

            // 燃料
            insert.setGasolineId01(0);
            insert.setGasolineId02(0);
            insert.setGasolineId03(0);
            insert.setGasolineId04(0);

            // 驅動
            insert.setRearWheelId01(0);
            insert.setRearWheelId02(0);
            insert.setRearWheelId03(0);

            // 車型
            insert.setSuspensionId01(0);
            insert.setSuspensionId02(0);
            insert.setSuspensionId03(0);
            insert.setSuspensionId04(0);
            insert.setSuspensionId05(0);
            insert.setSuspensionId06(0);

            // 打檔
            insert.setTransmissionId01(0);
            insert.setTransmissionId02(0);
            insert.setTransmissionId03(0);
            insert.setTransmissionId04(0);

            insert.setProductionYearAVG(new BigDecimal(0));// (出廠年份)
            insert.setMilageAVG(new BigDecimal(0));// (里程)
            insert.setScoreAVG(new BigDecimal(0));// (車評分)
            insert.setHpAVG(new BigDecimal(0));// (馬力)
            insert.setTorqueAVG(new BigDecimal(0));// (扭力)

            return customerRecordRepo.save(insert);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    // 修改
    public CustomerRecord modify(String json) {
        try {
            JSONObject obj = new JSONObject(json);
            Integer customerId = obj.isNull("customerId") ? null : obj.getInt("customerId");
            Integer brandId = obj.isNull("brandId") ? null : obj.getInt("brandId");
            Integer displacementId = obj.isNull("displacementId") ? null : obj.getInt("displacementId");
            Integer doorId = obj.isNull("doorId") ? null : obj.getInt("doorId");
            Integer passengerId = obj.isNull("passengerId") ? null : obj.getInt("passengerId");
            Integer gasolineId = obj.isNull("gasolineId") ? null : obj.getInt("gasolineId");
            Integer rearWheelId = obj.isNull("rearWheelId") ? null : obj.getInt("rearWheelId");
            Integer suspensionId = obj.isNull("suspensionId") ? null : obj.getInt("suspensionId");
            Integer transmissionId = obj.isNull("transmissionId") ? null : obj.getInt("transmissionId");
            BigDecimal productionYear = obj.isNull("productionYear") ? null : obj.getBigDecimal("productionYear");
            BigDecimal milage = obj.isNull("milage") ? null : obj.getBigDecimal("milage");
            BigDecimal score = obj.isNull("score") ? null : obj.getBigDecimal("score");
            BigDecimal hp = obj.isNull("hp") ? null : obj.getBigDecimal("hp");
            BigDecimal torque = obj.isNull("torque") ? null : obj.getBigDecimal("torque");

            Optional<CustomerRecord> optional = customerRecordRepo.findById(customerId);
            if (optional.isPresent()) {
                CustomerRecord update = optional.get();

                switch (brandId) {
                    case 1:
                        update.setBrandId01(update.getBrandId01() + 1);
                        break;
                    case 2:
                        update.setBrandId02(update.getBrandId02() + 1);
                        break;
                    case 3:
                        update.setBrandId03(update.getBrandId03() + 1);
                        break;
                    case 4:
                        update.setBrandId04(update.getBrandId04() + 1);
                        break;
                    case 5:
                        update.setBrandId05(update.getBrandId05() + 1);
                        break;
                    case 6:
                        update.setBrandId06(update.getBrandId06() + 1);
                        break;
                    case 7:
                        update.setBrandId07(update.getBrandId07() + 1);
                        break;
                    case 8:
                        update.setBrandId08(update.getBrandId08() + 1);
                        break;
                    case 9:
                        update.setBrandId09(update.getBrandId09() + 1);
                        break;
                    default:
                        break;
                }

                switch (displacementId) {
                    case 1:
                        update.setDisplacementId01(update.getDisplacementId01() + 1);
                        break;
                    case 2:
                        update.setDisplacementId02(update.getDisplacementId02() + 1);
                        break;
                    case 3:
                        update.setDisplacementId03(update.getDisplacementId03() + 1);
                        break;
                    case 4:
                        update.setDisplacementId04(update.getDisplacementId04() + 1);
                        break;
                    case 5:
                        update.setDisplacementId05(update.getDisplacementId05() + 1);
                        break;
                    case 6:
                        update.setDisplacementId06(update.getDisplacementId06() + 1);
                        break;
                    case 7:
                        update.setDisplacementId07(update.getDisplacementId07() + 1);
                        break;
                    default:
                        break;
                }

                switch (doorId) {
                    case 1:
                        update.setDoorId01(update.getDoorId01() + 1);
                        break;
                    case 2:
                        update.setDoorId02(update.getDoorId02() + 1);
                        break;
                    case 3:
                        update.setDoorId03(update.getDoorId03() + 1);
                        break;
                    case 4:
                        update.setDoorId04(update.getDoorId04() + 1);
                        break;
                    case 5:
                        update.setDoorId05(update.getDoorId05() + 1);
                        break;
                    default:
                        break;
                }

                switch (passengerId) {
                    case 1:
                        update.setPassengerId01(update.getPassengerId01() + 1);
                        break;
                    case 2:
                        update.setPassengerId02(update.getPassengerId02() + 1);
                        break;
                    case 3:
                        update.setPassengerId03(update.getPassengerId03() + 1);
                        break;
                    case 4:
                        update.setPassengerId04(update.getPassengerId04() + 1);
                        break;
                    default:
                        break;
                }

                switch (gasolineId) {
                    case 1:
                        update.setGasolineId01(update.getGasolineId01() + 1);
                        break;
                    case 2:
                        update.setGasolineId02(update.getGasolineId02() + 1);
                        break;
                    case 3:
                        update.setGasolineId03(update.getGasolineId03() + 1);
                        break;
                    case 4:
                        update.setGasolineId04(update.getGasolineId04() + 1);
                        break;
                    default:
                        break;
                }

                switch (rearWheelId) {
                    case 1:
                        update.setRearWheelId01(update.getRearWheelId01() + 1);
                        break;
                    case 2:
                        update.setRearWheelId02(update.getRearWheelId02() + 1);
                        break;
                    case 3:
                        update.setRearWheelId03(update.getRearWheelId03() + 1);
                        break;
                    default:
                        break;
                }

                switch (suspensionId) {
                    case 1:
                        update.setSuspensionId01(update.getSuspensionId01() + 1);
                        break;
                    case 2:
                        update.setSuspensionId02(update.getSuspensionId02() + 1);
                        break;
                    case 3:
                        update.setSuspensionId03(update.getSuspensionId03() + 1);
                        break;
                    case 4:
                        update.setSuspensionId04(update.getSuspensionId04() + 1);
                        break;
                    case 5:
                        update.setSuspensionId05(update.getSuspensionId05() + 1);
                        break;
                    case 6:
                        update.setSuspensionId06(update.getSuspensionId06() + 1);
                        break;
                    default:
                        break;
                }

                switch (transmissionId) {
                    case 1:
                        update.setTransmissionId01(update.getTransmissionId01() + 1);
                        break;
                    case 2:
                        update.setTransmissionId02(update.getTransmissionId02() + 1);
                        break;
                    case 3:
                        update.setTransmissionId03(update.getTransmissionId03() + 1);
                        break;
                    case 4:
                        update.setTransmissionId04(update.getTransmissionId04() + 1);
                        break;
                    default:
                        break;
                }

                BigDecimal countBD = BigDecimal.valueOf(update.getCount());
                BigDecimal countBDNew = BigDecimal.valueOf(update.getCount() + 1);

                update.setProductionYearAVG(countBD.multiply(update.getProductionYearAVG()).add(productionYear)
                        .divide(countBDNew, 2, RoundingMode.HALF_UP));
                update.setMilageAVG(countBD.multiply(update.getMilageAVG()).add(milage).divide(countBDNew, 2,
                        RoundingMode.HALF_UP));
                update.setScoreAVG(
                        countBD.multiply(update.getScoreAVG()).add(score).divide(countBDNew, 2, RoundingMode.HALF_UP));
                update.setHpAVG(
                        countBD.multiply(update.getHpAVG()).add(hp).divide(countBDNew, 2, RoundingMode.HALF_UP));
                update.setTorqueAVG(countBD.multiply(update.getTorqueAVG()).add(torque).divide(countBDNew, 2,
                        RoundingMode.HALF_UP));

                update.setCount(update.getCount() + 1);

                return customerRecordRepo.save(update);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Bean 轉 VO
    public CustomerRecordVO vOChange(CustomerRecord customerRecord) {
        CustomerRecordVO customerRecordVO = new CustomerRecordVO();

        BeanUtils.copyProperties(customerRecord, customerRecordVO);

        // 這邊要判斷 (Integer編號寫在VO) no01Care / no02Care / no03Care

        return customerRecordVO;
    }

}
