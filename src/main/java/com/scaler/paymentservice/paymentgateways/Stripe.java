package com.scaler.paymentservice.paymentgateways;

public class Stripe implements  IPaymentGateway{

    @Override
    public String createPaymentLink(Double amount, String orderId, String phoneNumber, String email, String name) {
        return "";
    }
}
