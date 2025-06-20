package com.acme.trackzonebackend.Payments.application.internal.queryservices;

import com.acme.trackzonebackend.Payments.domain.model.aggregates.UserSubscription;

import java.util.List;

public interface UserSubscriptionQueryService {
    List<UserSubscription> getAll();
    UserSubscription getById(Integer id);
}
