/*package com.acme.trackzonebackend.Payments.application.internal.commandservices;

import com.acme.trackzonebackend.Payments.domain.model.aggregates.Payment;
import com.acme.trackzonebackend.Payments.domain.model.commands.CreatePaymentCommand;
import com.acme.trackzonebackend.Payments.infrastructure.PaymentRepository;

public class PaymentCommandService {
    private final PaymentRepository repository;

    public PaymentCommandService(PaymentRepository repository) {
        this.repository = repository;
    }

    public Payment create(CreatePaymentCommand command) {
        return repository.save(Payment.builder()
                .amount(command.getAmount())
                .paymentTy(command.getPaymentTy())
                .build());
    }
}*/
