package com.acme.trackzonebackend.Payments.interfaces.transform;

import com.acme.trackzone.Payments.domain.model.commands.CreatePaymentCommand;
import com.acme.trackzone.Payments.interfaces.resources.CreatePaymentResource;
import org.springframework.stereotype.Component;

@Component
public class CreatePaymentCommandFromResourceAssembler {

    public CreatePaymentCommand toCommandFromResource(CreatePaymentResource resource) {
        return new CreatePaymentCommand(resource.getAmount(), resource.getPaymentTy());
    }
}
