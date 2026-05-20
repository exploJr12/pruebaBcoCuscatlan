package com.work.work.domain.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_details")

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = Carrito.class
    )

    @JoinColumn(name = "order_id")
    private Carrito order;

    private Long productId;

    private Integer quantity;

    private Double price;

    private Double subtotal;

    public OrderDetail(
            Carrito order,
            Long productId,
            Integer quantity,
            Double price
    ) {

        this.order = order;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;

        this.subtotal = quantity * price;
    }
}