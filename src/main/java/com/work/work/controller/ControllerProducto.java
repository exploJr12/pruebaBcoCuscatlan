package com.work.work.controller;

import com.work.work.domain.dto.producto.DtoActualizarProducto;
import com.work.work.domain.dto.producto.DtoProducto;
import com.work.work.domain.dto.producto.DtoProductoMostrar;
import com.work.work.domain.model.Producto;
import com.work.work.domain.repository.RepositoryProducto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("producto")
@RequiredArgsConstructor
@Transactional
@Tag(
        name = "Controlador de Productos",
        description = "Aca podremos modificar, actualizar, borrar y crear Productos"
)
public class ControllerProducto {

    private final RepositoryProducto repositoryProducto;

    @GetMapping("mostrar")
    public ResponseEntity<List<DtoProductoMostrar>> mostrar(){
        return ResponseEntity.ok(repositoryProducto.findAll().stream().map(DtoProductoMostrar::new).toList());
    }

    @PostMapping("crear")
    public ResponseEntity crear(@RequestBody @Valid DtoProducto dtoProducto, UriComponentsBuilder uriComponentsBuilder){
        var producto=repositoryProducto.save(new Producto(dtoProducto));
        URI url=uriComponentsBuilder.path("producto/unidad/{id}").buildAndExpand(producto.getId()).toUri();
        return ResponseEntity.created(url).body(new DtoProductoMostrar(producto));
    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity borrar(@PathVariable Long id){
        var producto=repositoryProducto.getReferenceById(id);
        repositoryProducto.delete(producto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody DtoActualizarProducto dtoActualizarProducto){
        var producto = repositoryProducto.getReferenceById(id);
        producto.actualizar(dtoActualizarProducto);
        return ResponseEntity.ok(new DtoProductoMostrar(producto));
    }

    @GetMapping("unidad/{id}")
    public ResponseEntity unidad(@PathVariable Long id){
        var producto=repositoryProducto.getReferenceById(id);
        return ResponseEntity.ok(new DtoProductoMostrar(producto));
    }

}
