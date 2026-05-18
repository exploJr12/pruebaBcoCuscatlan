package com.work.work.domain.dto.cliente;

import com.work.work.domain.model.Cliente;

public record DtoClienteCarrito(
        Long id,
        String nombre,
        String telefono
) {
    public DtoClienteCarrito(Cliente cliente){
        this(cliente.getId(), cliente.getNombre(), cliente.getTelefono());
    }
}
