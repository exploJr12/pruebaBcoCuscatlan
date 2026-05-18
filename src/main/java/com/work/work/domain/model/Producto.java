package com.work.work.domain.model;


import com.work.work.domain.dto.producto.DtoActualizarProducto;
import com.work.work.domain.dto.producto.DtoProducto;
import com.work.work.domain.enumDatos.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="producto")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String descripcion;
    private Integer precio;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Producto(DtoProducto dtoProducto) {
        this.marca= dtoProducto.marca();
        this.modelo=dtoProducto.modelo();
        this.descripcion= dtoProducto.descripcion();
        this.precio= dtoProducto.precio();
        this.categoria=dtoProducto.categoria();
    }

    public void actualizar(DtoActualizarProducto dtoActualizarProducto) {
        if(dtoActualizarProducto.marca() != ""){
            this.marca= dtoActualizarProducto.marca();
        }
        if(dtoActualizarProducto.modelo() != ""){
            this.modelo= dtoActualizarProducto.modelo();
        }
        if(dtoActualizarProducto.descripcion() != null){
            this.descripcion= dtoActualizarProducto.descripcion();
        }
        if(dtoActualizarProducto.precio() != null){
            this.precio= dtoActualizarProducto.precio();
        }
        if(dtoActualizarProducto.cateoria() != null){
            this.categoria= dtoActualizarProducto.cateoria();
        }
    }
}
