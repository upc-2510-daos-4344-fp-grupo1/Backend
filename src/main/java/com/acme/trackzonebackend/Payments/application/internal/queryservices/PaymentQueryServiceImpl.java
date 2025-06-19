package com.acme.trackzonebackend.Payments.application.internal.queryservices;

import com.acme.trackzonebackend.Payments.domain.model.aggregates.Payment;
import com.acme.trackzonebackend.Payments.domain.services.PaymentQueryService;
import com.acme.trackzonebackend.Payments.infrastructure.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class PaymentQueryServiceImpl implements PaymentQueryService {
    private final PaymentRepository repository;

    @Override
    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return repository.findById(id).orElseThrow();
    }
}
