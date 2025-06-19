package com.acme.trackzonebackend.Payments.infrastructure;

import com.acme.trackzonebackend.Payments.domain.model.aggregates.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {}
