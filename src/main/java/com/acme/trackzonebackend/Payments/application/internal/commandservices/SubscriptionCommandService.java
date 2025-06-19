package com.acme.trackzonebackend.Payments.application.internal.commandservices;

import com.acme.trackzone.Payments.domain.model.aggregates.Subscription;
import com.acme.trackzone.Payments.domain.model.commands.CreateSubscriptionCommand;
import com.acme.trackzone.Payments.infrastructure.PaymentRepository;
import com.acme.trackzone.Payments.infrastructure.SubscriptionRepository;

public class SubscriptionCommandService {
    private final SubscriptionRepository subscriptionRepo;
    private final PaymentRepository paymentRepo;

    public Subscription create(CreateSubscriptionCommand command) {
        return subscriptionRepo.save(Subscription.builder()
                .subscriptionTy(command.getSubscriptionTy())
                .paymentDate(command.getPaymentDate())
                .payment(paymentRepo.findById(command.getPaymentId()).orElseThrow())
                .build());
    }
}
