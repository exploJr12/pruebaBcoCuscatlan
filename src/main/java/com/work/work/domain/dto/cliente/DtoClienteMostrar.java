package com.work.work.domain.dto.cliente;

import com.work.work.domain.model.Cliente;

public record DtoClienteMostrar(
        Long id,
        String nombre,
        String telefono,
        String correo
) {
    public DtoClienteMostrar(Cliente cliente){
        this(cliente.getId(), cliente.getNombre(), cliente.getTelefono(), cliente.getCorreo());
    }
}
