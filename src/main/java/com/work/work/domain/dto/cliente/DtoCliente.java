package com.work.work.domain.dto.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DtoCliente(
        @NotNull(message = "nombre no puede estar vacio vacio") String nombre,
        @NotNull(message = "telefono no puede estar vacio vacio") String telefono,
        @NotNull(message = "correo no puede estar vacio vacio") @Email String correo
) {
}
