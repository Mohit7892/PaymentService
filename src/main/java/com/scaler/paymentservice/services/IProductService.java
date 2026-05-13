package com.scaler.paymentservice.services;

import com.razorpay.RazorpayException;

public interface IProductService {

    String getPaymentLink(Double amount, String orderId,
                          String phoneNumber, String email, String name,
                          String gateway) throws RazorpayException;
}
