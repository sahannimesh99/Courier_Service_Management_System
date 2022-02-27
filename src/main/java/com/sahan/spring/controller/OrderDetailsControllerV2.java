package com.sahan.spring.controller;

import com.sahan.spring.dto.OrderDetailDTOV2;
import com.sahan.spring.service.OrderDetailServiceV2;
import com.sahan.spring.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sahan Nimesha on 2022 - Feb
 * In IntelliJ IDEA
 */
@RestController
@RequestMapping("/api/v2/book-detail")
@CrossOrigin
public class OrderDetailsControllerV2 {

    private final OrderDetailServiceV2 orderDetailServiceV2;

    @Autowired
    public OrderDetailsControllerV2(OrderDetailServiceV2 orderDetailServiceV2) {
        this.orderDetailServiceV2 = orderDetailServiceV2;
    }

    @PostMapping("/")
    public ResponseEntity<?> addOrderDetail(@RequestBody OrderDetailDTOV2 dto) {
        orderDetailServiceV2.saveOrderDetail(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteOrderDetail(@RequestParam String orderId) {
        orderDetailServiceV2.deleteOrderDetail(orderId);
        return new ResponseEntity<>(new StandradResponse(200, "Success", null), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateOrderDetail(@RequestBody OrderDetailDTOV2 dto) {
        orderDetailServiceV2.updateOrderDetail(dto);
        return new ResponseEntity<>(new StandradResponse(200, "Success", null), HttpStatus.OK);
    }

    @GetMapping(path = "/{isbn}")
    public ResponseEntity<?> searchOrders(@PathVariable String orderId) {
        OrderDetailDTOV2 orderDetailDTO = orderDetailServiceV2.searchOrderDetail(orderId);
        return new ResponseEntity<>(new StandradResponse(200, "Success", orderDetailDTO), HttpStatus.OK);
    }

    @GetMapping("/view-all")
    public ResponseEntity<?> getAllOrders() {
        List<OrderDetailDTOV2> allOrderDetails = orderDetailServiceV2.getAllOrderDetail();
        return new ResponseEntity<>(new StandradResponse(200, "Success", allOrderDetails), HttpStatus.OK);
    }

}

