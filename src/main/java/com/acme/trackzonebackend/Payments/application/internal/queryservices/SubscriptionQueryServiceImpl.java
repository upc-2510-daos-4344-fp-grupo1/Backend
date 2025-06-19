package com.acme.trackzonebackend.Payments.application.internal.queryservices;

import com.acme.trackzone.Payments.domain.model.aggregates.Subscription;
import com.acme.trackzone.Payments.infrastructure.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SubscriptionQueryServiceImpl implements SubscriptionQueryService {
    private final SubscriptionRepository repository;

    @Override
    public List<Subscription> getAllSubscriptions() {
        return repository.findAll();
    }

    @Override
    public Subscription getSubscriptionById(Integer id) {
        return repository.findById(id).orElseThrow();
    }
}
