package com.scaler.paymentservice.services;

public interface IProductService {

    String getPaymentLink(Double amount, String orderId,
                          String phoneNumber, String email, String name);
}
