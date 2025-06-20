/*package com.acme.trackzonebackend.Payments.domain.services;

import com.acme.trackzonebackend.Payments.domain.model.aggregates.Subscription;
import com.acme.trackzonebackend.Payments.domain.model.aggregates.UserSubscription;
import com.acme.trackzonebackend.Payments.domain.model.commands.CreateUserSubscriptionCommand;
import com.acme.trackzonebackend.Payments.infrastructure.SubscriptionRepository;
import com.acme.trackzonebackend.Payments.infrastructure.UserSubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSubscriptionCommandService {
    private final UserSubscriptionRepository userSubscriptionRepo;
    private final SubscriptionRepository subscriptionRepo;

    public UserSubscription create(CreateUserSubscriptionCommand command) {
        Subscription subscription = subscriptionRepo.findById(command.getSubscriptionId())
                .orElseThrow(() -> new RuntimeException("Subscription not found"));

        return userSubscriptionRepo.save(UserSubscription.builder()
                .userId(command.getUserId())
                .subscription(subscription)
                .subscriptionStart(command.getSubscriptionStart())
                .subscriptionEnd(command.getSubscriptionEnd())
                .build());
    }
}*/