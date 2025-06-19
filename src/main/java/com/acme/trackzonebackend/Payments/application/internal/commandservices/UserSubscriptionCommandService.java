package com.acme.trackzonebackend.Payments.application.internal.commandservices;

import com.acme.trackzone.Payments.domain.model.aggregates.UserSubscription;
import com.acme.trackzone.Payments.domain.model.commands.CreateUserSubscriptionCommand;
import com.acme.trackzone.Payments.infrastructure.SubscriptionRepository;
import com.acme.trackzone.Payments.infrastructure.UserSubscriptionRepository;

public class UserSubscriptionCommandService {
    private final UserSubscriptionRepository userSubRepo;
    private final SubscriptionRepository subRepo;

    public UserSubscription create(CreateUserSubscriptionCommand command) {
        return userSubRepo.save(UserSubscription.builder()
                .userId(command.getUserId())
                .subscription(subRepo.findById(command.getSubscriptionId()).orElseThrow())
                .subscriptionStart(command.getSubscriptionStart())
                .subscriptionEnd(command.getSubscriptionEnd())
                .build());
    }
}
