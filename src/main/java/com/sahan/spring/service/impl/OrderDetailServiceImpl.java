package com.sahan.spring.service.impl;

import com.sahan.spring.dto.OrderDetailDTO;
import com.sahan.spring.entity.OrderDetail;
import com.sahan.spring.repo.OrderDetailRepo;
import com.sahan.spring.service.OrderDetailService;
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
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepo repo;
    private final ModelMapper mapper;

    @Autowired
    public OrderDetailServiceImpl(OrderDetailRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public void saveOrderDetail(OrderDetailDTO dto) {
        if (!repo.existsById(dto.getOrderId())) {
            OrderDetail orderDetail = mapper.map(dto, OrderDetail.class);
            repo.save(orderDetail);

        } else {
            throw new RuntimeException("Book already exist..!");
        }
    }

    @Override
    public void updateOrderDetail(OrderDetailDTO dto) {
        if (repo.existsById(dto.getOrderId())) {
            OrderDetail orderDetail = mapper.map(dto, OrderDetail.class);
            repo.save(orderDetail);
        } else {
            throw new RuntimeException("No such book for update..!");
        }
    }

    @Override
    public OrderDetailDTO searchOrderDetail(String orderId) {
        Optional<OrderDetail> orderDetail = repo.findById(orderId);
        if (orderDetail.isPresent()) {
            return mapper.map(orderDetail.get(), OrderDetailDTO.class);
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

    //view all saved and updated data in the database
    @Override
    public List<OrderDetailDTO> getAllOrderDetail() {
        List<OrderDetail> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<OrderDetailDTO>>() {
        }.getType());
    }

}

