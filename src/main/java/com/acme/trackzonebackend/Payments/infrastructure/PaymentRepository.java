package com.acme.trackzonebackend.Payments.infrastructure;

import com.acme.trackzonebackend.Payments.domain.model.aggregates.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findAllByPaymentsApiKey(String PaymentsApiKey);


    boolean existsByPaymentsApiKeyAndSourceId(String PaymentApiKey, String sourceId);


    Optional<Payment> findByNewsApiKeyAndSourceId(String PaymentsApiKey, String sourceId);
}
