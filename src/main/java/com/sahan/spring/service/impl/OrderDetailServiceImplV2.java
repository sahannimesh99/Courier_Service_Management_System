package com.sahan.spring.service.impl;

import com.sahan.spring.dto.OrderDetailDTOV2;
import com.sahan.spring.entity.OrderDetailV2;
import com.sahan.spring.repo.OrderDetailRepoV2;
import com.sahan.spring.service.OrderDetailServiceV2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sahan Nimesha on 2022 - Feb
 * In IntelliJ IDEA
 */
@Service
@Transactional
public class OrderDetailServiceImplV2 implements OrderDetailServiceV2 {
    private final OrderDetailRepoV2 repo;
    private final ModelMapper mapper;

    @Autowired
    public OrderDetailServiceImplV2(OrderDetailRepoV2 repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public void saveOrderDetail(OrderDetailDTOV2 dto) {
        if (!repo.existsById(dto.getOrderId())) {
            OrderDetailV2 c = mapper.map(dto, OrderDetailV2.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Book already exist..!");
        }
    }

    @Override
    public void updateOrderDetail(OrderDetailDTOV2 dto) {
        if (repo.existsById(dto.getOrderId())) {
            OrderDetailV2 c = mapper.map(dto, OrderDetailV2.class);
            repo.save(c);
        } else {
            throw new RuntimeException("No such book for update..!");
        }
    }

    @Override
    public OrderDetailDTOV2 searchOrderDetail(String orderId) {
        Optional<OrderDetailV2> orderDetail = repo.findById(orderId);
        if (orderDetail.isPresent()) {
            return mapper.map(orderDetail.get(), OrderDetailDTOV2.class);
        } else {
            throw new RuntimeException("No book for id: " + orderId);
        }
    }


    @Override
    public void deleteOrderDetail(String orderId) {
        if (repo.existsById(orderId)) {
            repo.deleteById(orderId);
        } else {
            throw new RuntimeException("No customer for delete ID: " + orderId);
        }

    }

    @Override
    public List<OrderDetailDTOV2> getAllOrderDetail() {
        List<OrderDetailV2> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<OrderDetailDTOV2>>() {
        }.getType());
    }

}
