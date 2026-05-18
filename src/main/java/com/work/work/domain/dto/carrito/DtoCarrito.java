package com.work.work.domain.dto.carrito;

import com.work.work.domain.model.Producto;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DtoCarrito(
        @NotNull String nombre,
        @NotNull List<Integer> productos
) {
}
