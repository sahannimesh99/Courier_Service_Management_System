package com.sahan.spring.controller;

import com.sahan.spring.SpringInitializer;
import com.sahan.spring.dto.OrderDetailDTO;
import com.sahan.spring.service.OrderDetailService;
import com.sahan.spring.service.impl.EmailSenderServiceImpl;
import com.sahan.spring.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by Sahan Nimesha on 2022 - Feb
 * In IntelliJ IDEA
 */

@RestController
@RequestMapping("/api/v1/order-detail")
@CrossOrigin
public class OrderDetailsController {

    private final OrderDetailService orderDetailService;
    private final EmailSenderServiceImpl service;

    @Autowired
    public OrderDetailsController(OrderDetailService orderDetailService, EmailSenderServiceImpl service) {
        this.orderDetailService = orderDetailService;
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<?> addOrderDetail(@RequestBody OrderDetailDTO dto) {
        orderDetailService.saveOrderDetail(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteOrderDetail(@RequestParam String orderId) {
        orderDetailService.deleteOrderDetail(orderId);
        return new ResponseEntity<>(new StandradResponse(200, "Success", null), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateOrderDetail(@RequestBody OrderDetailDTO dto) {
        orderDetailService.updateOrderDetail(dto);
        return new ResponseEntity<>(new StandradResponse(200, "Success", null), HttpStatus.OK);
    }

    @GetMapping(path = "/{orderId}")
    public ResponseEntity<?> searchOrders(@PathVariable String orderId) {
        OrderDetailDTO orderDetailDTO = orderDetailService.searchOrderDetail(orderId);
        return new ResponseEntity<>(new StandradResponse(200, "Success", orderDetailDTO), HttpStatus.OK);
    }

    @GetMapping("/view-all")
    public ResponseEntity<?> getAllOrders() {
        List<OrderDetailDTO> allOrderDetails = orderDetailService.getAllOrderDetail();
        return new ResponseEntity<>(new StandradResponse(200, "Success", allOrderDetails), HttpStatus.OK);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {
        service.sendEmailWithAttachment("spring.email.to@gmail.com --> courier company email",
                "This is Email Body with Attachment...",
                "This email has attachment",
                "This is an document attachment");

    }
}
