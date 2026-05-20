package com.work.work.controller;

import com.work.work.domain.dto.carrito.DtoCarrito;
import com.work.work.domain.dto.carrito.DtoCarritoActualizar;
import com.work.work.domain.dto.carrito.DtocarritoMostrar;

import com.work.work.domain.model.Carrito;

import com.work.work.domain.repository.RepositoryCarrito;
import com.work.work.domain.repository.RepositoryCliente;

import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carrito")
@RequiredArgsConstructor
@Transactional

@Tag(
        name = "Controlador de Ordenes",
        description = "Controlador para gestion de ordenes"
)

public class ControllerCarrito {

    private final RepositoryCarrito repositoryCarrito;
    private final RepositoryCliente repositoryCliente;

    @GetMapping("mostrar")
    public ResponseEntity<List<DtocarritoMostrar>> mostrar() {

        return ResponseEntity.ok(
                repositoryCarrito.findAll()
                        .stream()
                        .map(DtocarritoMostrar::new)
                        .toList()
        );
    }

    @PostMapping("crear")
    public ResponseEntity<?> crear(
            @RequestBody @Valid DtoCarrito dtoCarrito
    ) {

        var cliente = repositoryCliente.findById(dtoCarrito.clienteId());

        if (cliente.isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("Cliente no encontrado");
        }

        var carrito = repositoryCarrito.save(
                new Carrito(cliente.get())
        );

        return ResponseEntity.ok(
                new DtocarritoMostrar(carrito)
        );
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @RequestBody DtoCarritoActualizar dtoCarritoActualizar
    ) {

        var carrito = repositoryCarrito.getReferenceById(id);

        carrito.setTotal(dtoCarritoActualizar.total());
        carrito.setEstado(dtoCarritoActualizar.estado());

        return ResponseEntity.ok(
                new DtocarritoMostrar(carrito)
        );
    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        var carrito = repositoryCarrito.getReferenceById(id);

        repositoryCarrito.delete(carrito);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("unidad/{id}")
    public ResponseEntity<?> unidad(@PathVariable Long id) {

        var carrito = repositoryCarrito.getReferenceById(id);

        return ResponseEntity.ok(
                new DtocarritoMostrar(carrito)
        );
    }
}