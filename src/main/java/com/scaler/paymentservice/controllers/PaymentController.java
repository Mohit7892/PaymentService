package com.scaler.paymentservice.controllers;

import com.razorpay.RazorpayException;
import com.scaler.paymentservice.dtos.PaymentRequestDto;
import com.scaler.paymentservice.services.IProductService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private IProductService productService;

    @PostMapping("/{gateway}")
    public String generatePaymentLink(
            @RequestBody PaymentRequestDto paymentRequestDto,
            @PathVariable String gateway) throws RazorpayException, StripeException {

        return productService.getPaymentLink(paymentRequestDto.getAmount(),
                paymentRequestDto.getOrderId(), paymentRequestDto.getPhoneNumber(),
                paymentRequestDto.getEmail(), paymentRequestDto.getName(),
                gateway);
    }
}
