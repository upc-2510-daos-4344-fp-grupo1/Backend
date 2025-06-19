package com.acme.trackzonebackend.Payments.application.internal.commandservices;

import com.acme.trackzone.Payments.domain.model.aggregates.Payment;
import com.acme.trackzone.Payments.domain.model.commands.CreatePaymentCommand;
import com.acme.trackzone.Payments.infrastructure.PaymentRepository;

public class PaymentCommandService {
    private final PaymentRepository repository;

    public Payment create(CreatePaymentCommand command) {
        return repository.save(Payment.builder()
                .amount(command.getAmount())
                .paymentTy(command.getPaymentTy())
                .build());
    }
}
