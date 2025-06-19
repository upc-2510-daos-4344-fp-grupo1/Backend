package com.acme.trackzonebackend.Payments.interfaces.transform;

import com.acme.trackzone.Payments.domain.model.aggregates.Subscription;
import com.acme.trackzone.Payments.interfaces.resources.SubscriptionResource;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionResourceFromEntityAssembler {
    public SubscriptionResource toResourceFromEntity(Subscription subscription) {
        return SubscriptionResource.builder()
                .id(subscription.getId())
                .subscriptionTy(subscription.getSubscriptionTy())
                .paymentDate(subscription.getPaymentDate())
                .paymentId(subscription.getPayment().getId())
                .build();
    }
}
