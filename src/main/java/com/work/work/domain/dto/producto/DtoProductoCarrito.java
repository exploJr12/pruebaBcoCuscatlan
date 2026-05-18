package com.work.work.domain.dto.producto;

import com.work.work.domain.enumDatos.Categoria;
import com.work.work.domain.model.Producto;

public record DtoProductoCarrito(
        Long id,
        String marca,
        String modelo,
        String descripcion,
        Integer precio,
        Categoria categoria
) {
    public DtoProductoCarrito(Producto producto){
        this(producto.getId(), producto.getMarca(), producto.getModelo(),
                producto.getDescripcion(), producto.getPrecio(), producto.getCategoria());
    }
}
