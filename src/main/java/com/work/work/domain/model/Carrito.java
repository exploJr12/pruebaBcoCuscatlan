package com.work.work.domain.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ordenes")

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY,
            targetEntity = Cliente.class
    )
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private LocalDateTime fecha;

    private Double total;

    private String estado;

    public Carrito(Cliente cliente) {

        this.cliente = cliente;
        this.fecha = LocalDateTime.now();
        this.total = 0.0;
        this.estado = "PENDIENTE";
    }
}