package com.scaler.paymentservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StripeWebhookController {

    @PostMapping("/api/stripe/webhook")
    public void callWebhook(){
        System.out.println("Calling stripe webhook!!");
    }
}
