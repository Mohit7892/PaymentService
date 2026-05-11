package com.scaler.paymentservice.paymentgateways;

public interface IPaymentGateway {

    String createPaymentLink(Double amount, String orderId,
                             String phoneNumber, String email, String name);
}
