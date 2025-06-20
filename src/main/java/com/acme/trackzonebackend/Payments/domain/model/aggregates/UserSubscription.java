package com.acme.trackzonebackend.Payments.domain.model.aggregates;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_subscription")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public class UserSubscription {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "user_id")
        private Integer userId;

        @ManyToOne
        @JoinColumn(name = "subscription_id")
        private Subscription subscription;

        @Column(name = "subscription_start")
        private LocalDateTime subscriptionStart;

        @Column(name = "subscription_end")
        private LocalDateTime subscriptionEnd;
    }
