package com.acme.trackzonebackend.Payments.application.internal.commandservices;

import com.acme.trackzonebackend.Payments.domain.model.commands.CreatePaymentCommand;
import com.acme.trackzonebackend.Payments.domain.services.PaymentCommandService;
import com.acme.trackzonebackend.Payments.infrastructure.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentCommandServiceImpl implements PaymentCommandService {
    private final PaymentRepository favoriteSourceRepository;

    public PaymentCommandServiceImpl(PaymentRepository PaymentRepository) {
        this.PaymentRepository = PaymentRepository;
    }


    @Override
    public Optional<Payment> handle(CreatePaymentCommand command) {
        if (PaymentRepository.existsByNewsApiKeyAndSourceId(command.newsApiKey(), command.sourceId()))
            throw new IllegalArgumentException("Payment with same source ID already exists for this API key");
        var Payment = new Payment(command);
        var createdPayment = PaymentRepository.save(Payment);
        return Optional.of(createdPayment);
    }
}
