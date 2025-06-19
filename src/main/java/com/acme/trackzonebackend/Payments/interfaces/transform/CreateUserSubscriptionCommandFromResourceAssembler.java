package com.acme.trackzonebackend.Payments.interfaces.transform;

import com.acme.trackzonebackend.Payments.domain.model.commands.CreateUserSubscriptionCommand;
import org.springframework.stereotype.Component;

@Component
public class CreateUserSubscriptionCommandFromResourceAssembler {
    public CreateUserSubscriptionCommand toCommandFromResource(CreateUserSubscriptionResource resource) {
        return new CreateUserSubscriptionCommand(
                resource.getUserId(),
                resource.getSubscriptionId(),
                resource.getSubscriptionStart(),
                resource.getSubscriptionEnd()
        );
    }
}
