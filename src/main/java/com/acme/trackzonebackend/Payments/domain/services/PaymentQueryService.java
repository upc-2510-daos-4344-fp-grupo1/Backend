package com.acme.trackzonebackend.Payments.domain.services;

import com.acme.trackzone.Payments.domain.model.aggregates.Payment;

import java.util.List;

public interface PaymentQueryService {
    List<Payment> getAllPayments();
    Payment getPaymentById(Integer id);
}

