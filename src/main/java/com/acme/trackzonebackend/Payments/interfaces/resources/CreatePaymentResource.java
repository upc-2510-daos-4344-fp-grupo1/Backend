package com.acme.trackzonebackend.Payments.interfaces.resources;


public record CreatePaymentResource(String PaymentsApiKey, String sourceId) {

    public CreatePaymentResource {
        if (PaymentsApiKey == null || PaymentsApiKey.isBlank())
            throw new IllegalArgumentException("PaymentsApiKey cannot be null or empty");
        if (sourceId == null || sourceId.isBlank())
            throw new IllegalArgumentException("sourceId cannot be null or empty");
    }
}
