package com.acme.trackzonebackend.Payments.application.internal.queryservices;

import com.acme.trackzone.Payments.domain.model.aggregates.UserSubscription;
import com.acme.trackzone.Payments.infrastructure.UserSubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSubscriptionQueryServiceImpl implements UserSubscriptionQueryService {
    private final UserSubscriptionRepository repository;

    @Override
    public List<UserSubscription> getAll() {
        return repository.findAll();
    }

    @Override
    public UserSubscription getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }
}

