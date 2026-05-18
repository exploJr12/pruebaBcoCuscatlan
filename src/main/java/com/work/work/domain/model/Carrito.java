package com.work.work.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="carrito")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, targetEntity = Producto.class)
    @JoinTable(name = "carrito_productos",
            joinColumns = @JoinColumn(name = "carrito_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id"))
    private List<Producto> productos;
    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY,targetEntity= Cliente.class)
    private Cliente cliente;
    private LocalDate fecha;
    private Integer total;

    public Carrito(Cliente cliente, List<Producto> productos) {
        this.cliente=cliente;
        this.productos=productos;
        this.fecha=LocalDate.now();
        this.total=costoTotal(productos);
    }

    public Integer costoTotal(List<Producto> productos){
        Integer listaSuma=0;

        for (int i = 0; i < productos.size(); i++) {
           var valor= productos.get(i).getPrecio();
           listaSuma+=valor;
        }
        return listaSuma;
    }
}
