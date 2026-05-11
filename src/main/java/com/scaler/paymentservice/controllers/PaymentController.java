package com.scaler.paymentservice.controllers;

import com.scaler.paymentservice.dtos.PaymentRequestDto;
import com.scaler.paymentservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private IProductService productService;

    @PostMapping
    public String generatePaymentLink(@RequestBody PaymentRequestDto paymentRequestDto){

        return null;
    }
}
