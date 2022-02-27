package com.sahan.spring.service;

import com.sahan.spring.dto.OrderDetailDTO;

import java.util.List;

/**
 * Created by Sahan Nimesha on 2022 - Feb
 * In IntelliJ IDEA
 */
public interface OrderDetailService {
    void saveOrderDetail(OrderDetailDTO dto);

    void updateOrderDetail(OrderDetailDTO dto);

    OrderDetailDTO searchOrderDetail(String isbn);

    void deleteOrderDetail(String orderId);

    List<OrderDetailDTO> getAllOrderDetail();
}
