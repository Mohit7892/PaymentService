package com.scaler.paymentservice.paymentgateways;

import org.springframework.stereotype.Component;

@Component
public class Stripe implements  IPaymentGateway{

    @Override
    public String createPaymentLink(Double amount, String orderId,
                                    String phoneNumber, String email, String name) {
        return "";
    }
}
