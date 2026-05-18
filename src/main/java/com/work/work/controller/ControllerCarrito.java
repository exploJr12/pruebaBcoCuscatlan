package com.work.work.controller;


import com.work.work.domain.dto.carrito.DtoCarrito;
import com.work.work.domain.dto.carrito.DtocarritoMostrar;
import com.work.work.domain.model.Carrito;
import com.work.work.domain.model.Producto;
import com.work.work.domain.repository.RepositoryCarrito;
import com.work.work.domain.repository.RepositoryCliente;
import com.work.work.domain.repository.RepositoryProducto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("carrito")
@RequiredArgsConstructor
@Transactional
@Tag(
        name = "Controlador de Carrito de Compras",
        description = "Aca podremos borrar y crear Compras"
)
public class ControllerCarrito {

    private final RepositoryCarrito repositoryCarrito;
    private final RepositoryCliente repositoryCliente;
    private final RepositoryProducto repositoryProducto;

   @GetMapping("mostrar")
   public List<DtocarritoMostrar> mostrar(){
       return repositoryCarrito.findAll().stream().map(DtocarritoMostrar::new).toList();
   }

    @PostMapping("crear")
    public ResponseEntity crear(@RequestBody @Valid DtoCarrito dtoCarrito){
        var cliente= repositoryCliente.findByNombre(dtoCarrito.nombre());
        List<Producto>productos= new ArrayList<>();

        if(cliente!=null){
            for (Integer productoId: dtoCarrito.productos()) {
                Long id= Long.valueOf(productoId);
                var producto = repositoryProducto.findById(id);
                if(producto.isPresent()){
                   productos.add(producto.get());
                }
            }
             var carrito=repositoryCarrito.save(new Carrito(cliente,productos));
            return ResponseEntity.ok(new DtocarritoMostrar(carrito));
        }else {
            return ResponseEntity.ok("cliente no existe");
        }
    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
       var carrito=repositoryCarrito.getReferenceById(id);
       repositoryCarrito.delete(carrito);
        return ResponseEntity.noContent().build();
    }



    @GetMapping("unidad/{id}")
    public ResponseEntity crear(@PathVariable Long id){
       var carrito= repositoryCarrito.getReferenceById(id);
       return ResponseEntity.ok(new DtocarritoMostrar(carrito));
    }

}
