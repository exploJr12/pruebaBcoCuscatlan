package com.work.work.domain.model;

import com.work.work.domain.dto.cliente.DtoActualizarCliente;
import com.work.work.domain.dto.cliente.DtoCliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String telefono;
    private String correo;

    public Cliente(DtoCliente dtoCliente) {
        this.nombre= dtoCliente.nombre();
        this.telefono= dtoCliente.telefono();
        this.correo= dtoCliente.correo();
    }

    public void actualizar(DtoActualizarCliente dtoActualizarCliente) {
        if(dtoActualizarCliente.nombre()!=""){
            this.nombre= dtoActualizarCliente.nombre();
        }
        if(dtoActualizarCliente.telefono()!=""){
            this.telefono= dtoActualizarCliente.telefono();
        }
        if(dtoActualizarCliente.correo()!=""){
            this.correo= dtoActualizarCliente.correo();
        }
    }
}
