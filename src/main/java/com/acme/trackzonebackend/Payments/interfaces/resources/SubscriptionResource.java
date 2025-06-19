package com.acme.trackzonebackend.Payments.interfaces.resources;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionResource {
    private Integer id;
    private String subscriptionTy;
    private LocalDateTime paymentDate;
    private Integer paymentId;
}
