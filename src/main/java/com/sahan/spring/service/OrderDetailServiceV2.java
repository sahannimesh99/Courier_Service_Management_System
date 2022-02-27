package com.sahan.spring.service;

import com.sahan.spring.dto.OrderDetailDTOV2;

import java.util.List;

/**
 * Created by Sahan Nimesha on 2022 - Feb
 * In IntelliJ IDEA
 */
public interface OrderDetailServiceV2 {
    void saveOrderDetail(OrderDetailDTOV2 dto);

    void updateOrderDetail(OrderDetailDTOV2 dto);

    OrderDetailDTOV2 searchOrderDetail(String isbn);

    void deleteOrderDetail(String orderId);

    List<OrderDetailDTOV2> getAllOrderDetail();
}
