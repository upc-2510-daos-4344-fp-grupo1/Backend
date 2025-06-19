package com.acme.trackzonebackend.Payments.domain.services;

import com.acme.trackzonebackend.Payments.domain.model.aggregates.Payment;
import com.acme.trackzonebackend.Payments.domain.model.queries.GetAllPaymentByPaymentsApiKeyQuery;
import com.acme.trackzonebackend.Payments.domain.model.queries.GetPaymentByIdQuery;
import com.acme.trackzonebackend.Payments.domain.model.queries.GetPaymentByPaymentsApiKeyAndSourceIdQuery;


import java.util.List;
import java.util.Optional;

public interface PaymentQueryService {

    List<Payment> handle(GetAllPaymentByPaymentsApiKeyQuery query);

    Optional<Payment> handle(GetPaymentByIdQuery query);


    Optional<Payment> handle(GetPaymentByPaymentsApiKeyAndSourceIdQuery query);
}
