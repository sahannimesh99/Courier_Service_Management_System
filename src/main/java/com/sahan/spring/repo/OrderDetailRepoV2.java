package com.sahan.spring.repo;


import com.sahan.spring.entity.OrderDetailV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sahan Nimesha on 2022 - Feb
 * In IntelliJ IDEA
 */
@Repository
public interface OrderDetailRepoV2 extends JpaRepository<OrderDetailV2, String> {
//    OrderDetailV2 findByCourierCompanyCode(String courierCompanyCode);
//
//    List<OrderDetailV2> findAllByCourierCompanyCode(String courierCompanyCode);
//
//    OrderDetailV2 findOrderByOrderIdAndCourierCompanyCode(String orderId, String courierCompanyCode);
//
//    List<OrderDetailV2> findOrderDetailBySenderName(String senderName);
}
