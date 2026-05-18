package com.work.work.domain.dto.producto;

import com.work.work.domain.enumDatos.Categoria;
import jakarta.validation.constraints.NotNull;

public record DtoProducto(
        @NotNull(message = "marca no puede estar vacio") String marca,
        @NotNull(message = "modelo no puede estar vacio.") String modelo,
        @NotNull(message = "descripcion no puede estar vacio.") String descripcion,
        @NotNull(message = "categoria no puede estar vacio.") Categoria categoria,
        @NotNull(message = "precio no puede estar vacio") Integer precio
) {
}
