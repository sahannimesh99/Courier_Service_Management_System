package com.sahan.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Sahan Nimesha on 2022 - Feb
 * In IntelliJ IDEA
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderDetailV2 {
    @Id
    private String orderId;
    private String senderName;
    private String senderAddress;
    private String receiverName;
    private String receiverAddress;
    private String courierCompanyCode;
    private String parcelType;
}
