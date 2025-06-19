package com.acme.trackzonebackend.Payments.interfaces.resources;

/**
 * Resource record for a payment.
 * @summary
 * This record represents the resource for a payment.
 * It contains the ID, news API key, and source ID.
 * @since 1.0
 */
public record PaymentResource(Long id, String newsApiKey, String sourceId) {
}
