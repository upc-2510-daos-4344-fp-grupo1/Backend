package com.acme.trackzonebackend.Payments.interfaces.resources;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSubscriptionResource {
    private Integer id;
    private Integer userId;
    private Integer subscriptionId;
    private LocalDateTime subscriptionStart;
    private LocalDateTime subscriptionEnd;
}
