package com.sahan.spring.repo;

import com.sahan.spring.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sahan Nimesha on 2022 - Feb
 * In IntelliJ IDEA
 */
@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, String> {
//    OrderDetail findByCourierCompanyCode(String courierCompanyCode);
//
//    List<OrderDetail> findAllByCourierCompanyCode(String courierCompanyCode);
//
//    OrderDetail findOrderByOrderIdAndCourierCompanyCode(String orderId, String courierCompanyCode);
//
//    List<OrderDetail> findOrderDetailBySenderName(String senderName);
}
