package com.acme.trackzonebackend.Payments.interfaces.transform;

import com.acme.trackzonebackend.Payments.domain.model.commands.CreateSubscriptionCommand;
import com.acme.trackzonebackend.Payments.interfaces.resources.CreateSubscriptionResource;
import org.springframework.stereotype.Component;

@Component
public class CreateSubscriptionCommandFromResourceAssembler {
    public CreateSubscriptionCommand toCommandFromResource(CreateSubscriptionResource resource) {
        return new CreateSubscriptionCommand(
                resource.getSubscriptionTy(),
                resource.getPaymentDate(),
                resource.getPaymentId()
        );
    }
}
