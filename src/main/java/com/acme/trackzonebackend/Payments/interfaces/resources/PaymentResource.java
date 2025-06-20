package com.acme.trackzonebackend.Payments.interfaces.resources;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResource {
    private Integer id;
    private Integer amount;
    private String paymentTy;
}
