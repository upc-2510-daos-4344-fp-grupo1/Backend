package com.acme.trackzonebackend.Payments.interfaces.resources;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePaymentResource {

    private Integer amount;
    private String paymentTy;
}
