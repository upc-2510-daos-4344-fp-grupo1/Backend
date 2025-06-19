package com.acme.trackzonebackend.Payments.domain.services;

import com.acme.trackzonebackend.Payments.domain.model.aggregates.Subscription;

import java.util.List;

public interface SubscriptionQueryService {
    List<Subscription> getAllSubscriptions();
    Subscription getSubscriptionById(Integer id);
}
