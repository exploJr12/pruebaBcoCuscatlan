package com.work.work.domain.dto.carrito;

import com.work.work.domain.dto.cliente.DtoClienteCarrito;
import com.work.work.domain.dto.producto.DtoProductoCarrito;
import com.work.work.domain.model.Carrito;

import java.time.LocalDate;
import java.util.List;

public record DtocarritoMostrar(
        Long id,
        LocalDate fecha,
        DtoClienteCarrito dtoClienteCarrito,
        List<DtoProductoCarrito> Productos,
        Integer total
) {
    public DtocarritoMostrar(Carrito carrito){
        this(carrito.getId(), carrito.getFecha(),new DtoClienteCarrito(carrito.getCliente()),
                carrito.getProductos().stream().map(DtoProductoCarrito::new).toList(),
                carrito.getTotal());
    }
}
