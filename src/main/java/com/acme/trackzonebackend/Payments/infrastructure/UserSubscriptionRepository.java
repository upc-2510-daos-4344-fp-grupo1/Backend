package com.acme.trackzonebackend.Payments.infrastructure;

import com.acme.trackzonebackend.Payments.domain.model.aggregates.UserSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Integer> {}
