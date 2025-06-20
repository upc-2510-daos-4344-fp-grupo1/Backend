package com.acme.trackzonebackend.Payments.application.internal.commandservices;

import com.acme.trackzonebackend.Payments.domain.model.aggregates.UserSubscription;
import com.acme.trackzonebackend.Payments.domain.model.commands.CreateUserSubscriptionCommand;
import com.acme.trackzonebackend.Payments.infrastructure.SubscriptionRepository;
import com.acme.trackzonebackend.Payments.infrastructure.UserSubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
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
