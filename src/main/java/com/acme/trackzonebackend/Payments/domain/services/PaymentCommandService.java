package com.acme.trackzonebackend.Payments.domain.services;

import com.acme.trackzonebackend.Payments.domain.model.aggregates.Payment;
import com.acme.trackzonebackend.Payments.domain.model.commands.CreatePaymentCommand;

import java.util.Optional;


public interface PaymentCommandService {

    Optional<Payment> handle(CreatePaymentCommand command);
}
