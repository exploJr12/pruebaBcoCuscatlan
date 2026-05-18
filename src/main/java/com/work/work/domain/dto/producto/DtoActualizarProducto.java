package com.work.work.domain.dto.producto;

import com.work.work.domain.enumDatos.Categoria;

public record DtoActualizarProducto(
         String marca,
         String modelo,
         String descripcion,
         Categoria cateoria,
         Integer precio
) {
}
