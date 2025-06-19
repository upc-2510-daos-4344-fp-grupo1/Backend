package com.acme.trackzonebackend.Payments.domain.model.aggregates;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "subscription")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Subscription {

    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public class Subscription {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "subscription_ty", length = 60)
        private String subscriptionTy;

        @Column(name = "payment_date")
        private LocalDateTime paymentDate;

        @ManyToOne
        @JoinColumn(name = "payment_id")
        private Payment payment;
    }

}

