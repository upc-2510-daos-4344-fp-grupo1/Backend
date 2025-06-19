package com.acme.trackzonebackend.Payments.interfaces.transform;

import com.acme.trackzonebackend.Payments.domain.model.commands.CreatePaymentCommand;
import com.acme.trackzonebackend.Payments.interfaces.resources.CreatePaymentResource;


public class CreatePaymentCommandFromResourceAssembler {

    public static CreatePaymentCommand toCommandFromResource(CreatePaymentResource resource) {
        return new CreatePaymentCommand(resource.PaymentsApiKey(), resource.sourceId());
    }
}
