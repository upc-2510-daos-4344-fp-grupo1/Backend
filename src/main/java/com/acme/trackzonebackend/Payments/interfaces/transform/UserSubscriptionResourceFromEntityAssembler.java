package com.acme.trackzonebackend.Payments.interfaces.transform;

import com.acme.trackzone.Payments.interfaces.resources.UserSubscriptionResource;
import org.springframework.stereotype.Component;

@Component
public class UserSubscriptionResourceFromEntityAssembler {
    public UserSubscriptionResource toResourceFromEntity(UserSubscription userSub) {
        return UserSubscriptionResource.builder()
                .id(userSub.getId())
                .userId(userSub.getUserId())
                .subscriptionId(userSub.getSubscription().getId())
                .subscriptionStart(userSub.getSubscriptionStart())
                .subscriptionEnd(userSub.getSubscriptionEnd())
                .build();
    }
}
