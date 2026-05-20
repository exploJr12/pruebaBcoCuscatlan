package com.work.work.controller;

import com.work.work.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("producto")
@RequiredArgsConstructor
@Transactional

@Tag(
        name = "Controlador de Productos",
        description = "Controlador conectado a FakeStoreAPI"
)

public class ControllerProducto {

    private final ProductService productService;

    @GetMapping("mostrar")
    public ResponseEntity<?> mostrar() {

        return ResponseEntity.ok(
                productService.obtenerProductos()
        );
    }

    @GetMapping("unidad/{id}")
    public ResponseEntity<?> unidad(@PathVariable Long id) {

        return ResponseEntity.ok(
                productService.obtenerProducto(id)
        );
    }
}