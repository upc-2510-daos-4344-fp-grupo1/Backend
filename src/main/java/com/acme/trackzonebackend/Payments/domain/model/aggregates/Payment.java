package com.acme.trackzonebackend.Payments.domain.model.aggregates;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer amount;

    @Column(nullable = false)
    @Getter
    private String PaymentsApiKey;

    @Column(name = "payment_ty", length = 60)
    private String paymentTy;
}

