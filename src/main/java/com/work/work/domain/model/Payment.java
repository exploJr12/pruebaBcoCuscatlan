package com.work.work.domain.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = Carrito.class
    )

    @JoinColumn(name = "order_id")
    private Carrito order;

    private Double amount;

    private String paymentMethod;

    private String status;

    private LocalDateTime paymentDate;

    public Payment(
            Carrito order,
            Double amount,
            String paymentMethod
    ) {

        this.order = order;
        this.amount = amount;
        this.paymentMethod = paymentMethod;

        this.status = "PAID";

        this.paymentDate = LocalDateTime.now();
    }
}