package com.scaler.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequestDto {

    private Double amount;
    private String orderId;
    private Integer phoneNumber;
    private String email;
    private String name;
}
