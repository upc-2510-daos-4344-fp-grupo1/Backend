package com.acme.trackzonebackend.Payments.domain.model.commands;

public class CreateUserSubscriptionCommand {
    private Integer userId;
    private Integer subscriptionId;
    private LocalDateTime subscriptionStart;
    private LocalDateTime subscriptionEnd;
}
