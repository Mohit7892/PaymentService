package com.scaler.paymentservice.paymentgateways;

import com.stripe.StripeClient;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Stripe implements  IPaymentGateway{

    @Value("${stripe.api.key}")
    private String apiKey;

    @Override
    public String createPaymentLink(Double amount, String orderId,
                                    String phoneNumber, String email, String name) throws StripeException {

        StripeClient client = new StripeClient(apiKey);
         /*
        Create the Price object
         */

        PriceCreateParams priceParams =
                PriceCreateParams.builder()
                        .setCurrency("inr")
                        .setUnitAmount(amount.longValue())
                        .setRecurring(
                                PriceCreateParams.Recurring.builder()
                                        .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
                                        .build()
                        )
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName("Test product Scaler").build()
                        )
                        .build();
        Price price = client.v1().prices().create(priceParams);

          /*
        Create the payment object
         */

        PaymentLinkCreateParams paymentParams =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        ).setAfterCompletion(PaymentLinkCreateParams.AfterCompletion.builder()
                                .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                .setRedirect(PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                        .setUrl("http://www.google.com").build())
                                .build()

                        ).build();
        PaymentLink paymentLink = client.v1().paymentLinks().create(paymentParams);
        return paymentLink.getUrl();
    }
}
