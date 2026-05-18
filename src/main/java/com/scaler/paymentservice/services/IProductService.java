package com.scaler.paymentservice.services;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface IProductService {

    String getPaymentLink(Double amount, String orderId,
                          String phoneNumber, String email, String name,
                          String gateway) throws RazorpayException, StripeException;
}
