package com.work.work.domain.dto.carrito;

import jakarta.validation.constraints.NotNull;

public record DtoCarrito(

        @NotNull
        Long clienteId

) {
}