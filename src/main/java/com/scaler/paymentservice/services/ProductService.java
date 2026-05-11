package com.scaler.paymentservice.services;

import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{

    @Override
    public String getPaymentLink(Double amount, String orderId,
                                 String phoneNumber, String email, String name) {
        return "";
    }
}
