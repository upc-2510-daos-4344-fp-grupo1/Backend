package com.acme.trackzonebackend.Payments.domain.model.queries;

/**
 * @summary
 * This class represents the query to get all favorite sources by newsApiKey.
 * @param newsApiKey - the newsApiKey to get all favorite sources.
 */
public record GetAllPaymentByPaymentsApiKeyQuery(String newsApiKey) {
    public GetAllPaymentByPaymentsApiKeyQuery {
        if (paymentsApiKey == null || paymentssApiKey.isBlank())
            throw new IllegalArgumentException("newsApiKey cannot be null or empty");

    }
}

