package com.acme.trackzonebackend.Payments.infrastructure;

import com.acme.trackzone.Payments.domain.model.aggregates.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {}

