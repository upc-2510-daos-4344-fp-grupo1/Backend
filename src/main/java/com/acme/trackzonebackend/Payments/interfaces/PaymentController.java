package com.acme.trackzonebackend.Payments.interfaces;


import com.acme.trackzonebackend.Payments.application.internal.commandservices.SubscriptionCommandService;
import com.acme.trackzonebackend.Payments.application.internal.commandservices.UserSubscriptionCommandService;
import com.acme.trackzonebackend.Payments.application.internal.queryservices.SubscriptionQueryService;
import com.acme.trackzonebackend.Payments.application.internal.queryservices.UserSubscriptionQueryService;
import com.acme.trackzonebackend.Payments.domain.services.PaymentCommandService;
import com.acme.trackzonebackend.Payments.domain.services.PaymentQueryService;
import com.acme.trackzonebackend.Payments.interfaces.resources.*;
import com.acme.trackzonebackend.Payments.interfaces.transform.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentCommandService paymentCommandService;
    private final PaymentQueryService paymentQueryService;

    private final CreatePaymentCommandFromResourceAssembler commandAssembler;
    private final PaymentResourceFromEntityAssembler resourceAssembler;

    @PostMapping
    public PaymentResource create(@RequestBody CreatePaymentResource resource) {
        var command = commandAssembler.toCommandFromResource(resource);
        var payment = paymentCommandService.create(command);
        return resourceAssembler.toResourceFromEntity(payment);
    }

    @GetMapping
    public List<PaymentResource> getAll() {
        return paymentQueryService.getAllPayments()
                .stream()
                .map(resourceAssembler::toResourceFromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public PaymentResource getById(@PathVariable Integer id) {
        return resourceAssembler.toResourceFromEntity(
                paymentQueryService.getPaymentById(id)
        );
    }
    // --- Subscription ---
    private final SubscriptionCommandService subscriptionCommandService;
    private final SubscriptionQueryService subscriptionQueryService;
    private final CreateSubscriptionCommandFromResourceAssembler subscriptionCommandAssembler;
    private final SubscriptionResourceFromEntityAssembler subscriptionAssembler;
    @PostMapping("/subscriptions")
    public SubscriptionResource createSubscription(@RequestBody CreateSubscriptionResource resource) {
        var command = subscriptionCommandAssembler.toCommandFromResource(resource);
        var subscription = subscriptionCommandService.create(command);
        return subscriptionAssembler.toResourceFromEntity(subscription);
    }

    @GetMapping("/subscriptions")
    public List<SubscriptionResource> getAllSubscriptions() {
        return subscriptionQueryService.getAllSubscriptions().stream()
                .map(subscriptionAssembler::toResourceFromEntity)
                .toList();
    }

    // --- User-Subscription ---
    private final UserSubscriptionCommandService userSubCommandService;
    private final UserSubscriptionQueryService userSubQueryService;
    private final CreateUserSubscriptionCommandFromResourceAssembler userSubCommandAssembler;
    private final UserSubscriptionResourceFromEntityAssembler userSubAssembler;
    @PostMapping("/user-subscriptions")
    public UserSubscriptionResource createUserSubscription(@RequestBody CreateUserSubscriptionResource resource) {
        var command = userSubCommandAssembler.toCommandFromResource(resource);
        var entity = userSubCommandService.create(command);
        return userSubAssembler.toResourceFromEntity(entity);
    }

    @GetMapping("/user-subscriptions")
    public List<UserSubscriptionResource> getAllUserSubscriptions() {
        return userSubQueryService.getAll().stream()
                .map(userSubAssembler::toResourceFromEntity)
                .toList();
    }
}


