package com.acme.trackzonebackend.Payments.application.internal.queryservices;

import com.acme.trackzonebackend.Payments.domain.model.queries.GetAllPaymentByPaymentsApiKeyQuery;
import com.acme.trackzonebackend.Payments.domain.model.queries.GetPaymentByIdQuery;
import com.acme.trackzonebackend.Payments.domain.model.queries.GetPaymentByPaymentsApiKeyAndSourceIdQuery;
import com.acme.trackzonebackend.Payments.domain.services.PaymentQueryService;
import com.acme.trackzonebackend.Payments.infrastructure.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * FavoriteSourceQueryService Implementation
 *
 * @summary
 * Implementation of the FavoriteSourceQueryService interface.
 * It is responsible for handling favorite source queries.
 *
 * @since 1.0
 */
@Service
public class PaymentQueryServiceImpl implements PaymentQueryService {
    private final PaymentRepository PaymentRepository;

    public PaymentQueryServiceImpl(PaymentRepository PaymentRepository) {
        this.PaymentRepository = PaymentRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Payment> handle(GetAllPaymentByPaymentsApiKeyQuery query) {
        return PaymentRepository.findAllByPaymentsApiKey(query.newsApiKey());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Payment> handle(GetPaymentByIdQuery query) {
        return PaymentRepository.findById(query.id());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Payment> handle(GetPaymentByPaymentsApiKeyAndSourceIdQuery query) {
        return PaymentRepository.findByPaymentsApiKeyAndSourceId(query.newsApiKey(), query.sourceId());
    }
}
