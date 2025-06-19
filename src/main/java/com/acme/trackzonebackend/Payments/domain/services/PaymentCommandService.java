package com.acme.trackzonebackend.Payments.domain.services;

import com.acme.trackzonebackend.Payments.domain.model.aggregates.Payment;
import com.acme.trackzonebackend.Payments.domain.model.commands.CreatePaymentCommand;
import com.acme.trackzonebackend.Payments.infrastructure.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class PaymentCommandService {
    private final PaymentRepository repository;

    public Payment create(CreatePaymentCommand command) {
        return repository.save(Payment.builder()
                .amount(command.getAmount())
                .paymentTy(command.getPaymentTy())
                .build());
    }
}
