package com.work.work.domain.dto.carrito;

import com.work.work.domain.model.Producto;

import java.util.List;

public record DtoCarritoActualizar(
        String nombre,
        List<Producto> productos
) {
}
