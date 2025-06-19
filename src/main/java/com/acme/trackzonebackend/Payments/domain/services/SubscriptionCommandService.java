package com.acme.trackzonebackend.Payments.domain.services;

import com.acme.trackzonebackend.Payments.domain.model.aggregates.Payment;
import com.acme.trackzonebackend.Payments.domain.model.aggregates.Subscription;
import com.acme.trackzonebackend.Payments.domain.model.commands.CreateSubscriptionCommand;
import com.acme.trackzonebackend.Payments.infrastructure.PaymentRepository;
import com.acme.trackzonebackend.Payments.infrastructure.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionCommandService {
    private final SubscriptionRepository subscriptionRepository;
    private final PaymentRepository paymentRepository;

    public Subscription create(CreateSubscriptionCommand command) {
        Payment payment = paymentRepository.findById(command.getPaymentId())
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        return subscriptionRepository.save(
                Subscription.builder()
                        .subscriptionTy(command.getSubscriptionTy())
                        .paymentDate(command.getPaymentDate())
                        .payment(payment)
                        .build()
        );
    }
}
