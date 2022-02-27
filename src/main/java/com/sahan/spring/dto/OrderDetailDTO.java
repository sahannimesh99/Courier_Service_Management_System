package com.sahan.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sahan Nimesha on 2022 - Feb
 * In IntelliJ IDEA
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {
    private String orderId;
    private String senderName;
    private String senderAddress;
    private String receiverName;
    private String receiverAddress;
    private String courierCompanyCode;
}
