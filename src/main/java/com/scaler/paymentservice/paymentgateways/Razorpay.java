package com.scaler.paymentservice.paymentgateways;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Razorpay implements  IPaymentGateway {

    @Autowired
    private RazorpayClient razorpayClient;

    @Override
    public String createPaymentLink(Double amount, String orderId,
                                    String phoneNumber, String email, String name) throws RazorpayException {

        //call razor pay apis using razorpay client
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", amount);
        paymentLinkRequest.put("currency", "INR");
        paymentLinkRequest.put("accept_partial", true);
        paymentLinkRequest.put("first_min_partial_amount", 100);
        paymentLinkRequest.put("expire_by", System.currentTimeMillis() + 10*60*1000); // Dynamic Expiry, adding 10 min to current time
        paymentLinkRequest.put("reference_id", orderId.toString());
        paymentLinkRequest.put("description", "Payment request testing of Razorpay API");

        JSONObject customer = new JSONObject();
        customer.put("name", name); // Target text uses phoneNumber/name interchangeably here; logic should follow DTO
        customer.put("contact", phoneNumber);
        customer.put("email", email);
        paymentLinkRequest.put("customer", customer);

        JSONObject notify = new JSONObject();
        notify.put("sms", true);
        notify.put("email", true);
        paymentLinkRequest.put("notify", notify);
        paymentLinkRequest.put("reminder_enable", true);

        JSONObject notes = new JSONObject();
        notes.put("policy_name", "Life Insurance Policy");
        paymentLinkRequest.put("notes", notes);
        paymentLinkRequest.put("callback_url", "https://www.scaler.com/");
        paymentLinkRequest.put("callback_method", "get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
        return payment.get("short_url").toString();
    }
}
