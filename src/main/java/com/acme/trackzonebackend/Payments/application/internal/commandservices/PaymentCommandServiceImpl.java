package com.acme.trackzonebackend.Payments.application.internal.commandservices;

import com.acme.trackzonebackend.Payments.domain.model.aggregates.Payment;
import com.acme.trackzonebackend.Payments.domain.model.commands.CreatePaymentCommand;
import com.acme.trackzonebackend.Payments.domain.services.PaymentCommandService;
import com.acme.trackzonebackend.Payments.infrastructure.persistence.jpa.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * FavoriteSourceCommandService Implementation
 *
 * @summary
 * Implementation of the FavoriteSourceCommandService interface.
 * It is responsible for handling favorite source commands.
 *
 * @since 1.0
 */
@Service
public class PaymentCommandServiceImpl implements PaymentCommandService {
    private final PaymentRepository favoriteSourceRepository;

    public PaymentCommandServiceImpl(PaymentRepository PaymentRepository) {
        this.PaymentRepository = PaymentRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Payment> handle(CreatePaymentCommand command) {
        if (PaymentRepository.existsByNewsApiKeyAndSourceId(command.newsApiKey(), command.sourceId()))
            throw new IllegalArgumentException("Favorite source with same source ID already exists for this API key");
        var favoriteSource = new Payment(command);
        var createdPayment = PaymentRepository.save(Payment);
        return Optional.of(createdPayment);
    }
}
