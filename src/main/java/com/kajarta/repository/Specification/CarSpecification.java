package com.kajarta.repository.Specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.kajarta.demo.model.Car;
import com.kajarta.demo.model.Carinfo;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;

public class CarSpecification {

    public static Specification<Car> dynamicSearch(String modelName, Integer productionYear, BigDecimal price,
            Integer milage, Integer score, Integer hp, Double torque) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // 连接 Car 和 Carinfo
            Join<Car, Carinfo> carinfoJoin = root.join("carinfo", JoinType.LEFT);

            // 添加查询条件
            if (modelName != null && !modelName.isEmpty()) {
                predicates.add(cb.like(carinfoJoin.get("modelName"), "%" + modelName + "%"));
            }
            if (productionYear != null) {
                predicates.add(cb.like(cb.toString(root.get("productionYear")), "%" + productionYear + "%"));
            }
            if (price != null) {
                predicates.add(cb.like(cb.toString(root.get("price")), "%" + price + "%"));
            }
            if (milage != null) {
                predicates.add(cb.like(cb.toString(root.get("milage")), "%" + milage + "%"));
            }
            if (score != null) {
                predicates.add(cb.like(cb.toString(root.get("conditionScore")), "%" + score + "%"));
            }
            if (hp != null) {
                predicates.add(cb.like(cb.toString(carinfoJoin.get("hp")), "%" + hp + "%"));
            }
            if (torque != null) {
                predicates.add(cb.like(cb.toString(carinfoJoin.get("torque")), "%" + torque + "%"));
            }

            // 返回所有条件
            return cb.and(predicates.toArray(new Predicate[0]));

        };
    }
}
