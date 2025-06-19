package com.acme.trackzonebackend.Payments.interfaces.transform;

import com.acme.trackzonebackend.Payments.domain.model.aggregates.Payment;
import com.acme.trackzonebackend.Payments.interfaces.resources.PaymentResource;
import org.springframework.stereotype.Component;

@Component
public class PaymentResourceFromEntityAssembler {

    public PaymentResource toResourceFromEntity(Payment payment) {
        return PaymentResource.builder()
                .id(payment.getId())
                .amount(payment.getAmount())
                .paymentTy(payment.getPaymentTy())
                .build();
    }
}
