package com.scaler.paymentservice.services;

import com.razorpay.RazorpayException;
import com.scaler.paymentservice.paymentgateways.IPaymentGateway;
import com.scaler.paymentservice.paymentgateways.PaymentGatewayChooserStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    private PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;

    @Override
    public String getPaymentLink(Double amount, String orderId,
                                 String phoneNumber, String email, String name,
                                 String gateway) throws RazorpayException {

        IPaymentGateway iPaymentGateway = paymentGatewayChooserStrategy
                .getPaymentGateway(gateway);

        return iPaymentGateway.createPaymentLink(
                amount, orderId, phoneNumber, email, name);
    }
}
