package com.acme.trackzonebackend.Payments.domain.model.queries;

public record GetPaymentByPaymentsApiKeyAndSourceIdQuery(String newsApiKey, String sourceId) {
    public GetPaymentByPaymentsApiKeyAndSourceIdQuery {
        if (newsApiKey == null || newsApiKey.isBlank())
            throw new IllegalArgumentException("newsApiKey cannot be null or empty");
        if (sourceId == null || sourceId.isBlank())
            throw new IllegalArgumentException("sourceId cannot be null or empty");
    }
}
