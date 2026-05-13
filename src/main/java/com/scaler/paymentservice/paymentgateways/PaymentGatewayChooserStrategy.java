package com.scaler.paymentservice.paymentgateways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayChooserStrategy {

    @Autowired
    private Razorpay razorpay;
    @Autowired
    private Stripe stripe;

    public IPaymentGateway getPaymentGateway(String gateway){
        if(gateway.equalsIgnoreCase("razorpay"))
            return razorpay;
        else if (gateway.equalsIgnoreCase("stripe"))
            return stripe;
        else
            return null;
    }
}
