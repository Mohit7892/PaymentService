package com.scaler.paymentservice.paymentgateways;

import com.razorpay.RazorpayException;

public interface IPaymentGateway {

    String createPaymentLink(Double amount, String orderId,
                             String phoneNumber, String email, String name) throws RazorpayException;
}
