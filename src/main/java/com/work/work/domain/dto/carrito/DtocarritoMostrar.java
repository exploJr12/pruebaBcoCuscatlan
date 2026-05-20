package com.work.work.domain.dto.carrito;

import com.work.work.domain.model.Carrito;

import java.time.LocalDateTime;

public record DtocarritoMostrar(

        Long id,
        LocalDateTime fecha,
        String cliente,
        Double total,
        String estado

) {

    public DtocarritoMostrar(Carrito carrito) {

        this(
                carrito.getId(),
                carrito.getFecha(),
                carrito.getCliente().getNombre(),
                carrito.getTotal(),
                carrito.getEstado()
        );
    }
}