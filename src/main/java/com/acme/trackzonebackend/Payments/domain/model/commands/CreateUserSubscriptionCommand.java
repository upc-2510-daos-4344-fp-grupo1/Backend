package com.acme.trackzonebackend.Payments.domain.model.commands;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserSubscriptionCommand {
    private Integer userId;
    private Integer subscriptionId;
    private LocalDateTime subscriptionStart;
    private LocalDateTime subscriptionEnd;
}
