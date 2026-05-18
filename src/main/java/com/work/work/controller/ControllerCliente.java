package com.work.work.controller;


import com.work.work.domain.dto.cliente.DtoActualizarCliente;
import com.work.work.domain.dto.cliente.DtoCliente;
import com.work.work.domain.dto.cliente.DtoClienteMostrar;
import com.work.work.domain.model.Cliente;
import com.work.work.domain.repository.RepositoryCliente;
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
@RequestMapping("cliente")
@RequiredArgsConstructor
@Transactional
@Tag(
        name = "Controlador de Clientes",
        description = "Aca podremos modificar, actualizar, borrar y crear Clientes"
)
public class ControllerCliente {

    private final RepositoryCliente repositoryCliente;

    @GetMapping("mostrar")
    public ResponseEntity<List<DtoClienteMostrar>> mostrar(){
        return ResponseEntity.ok(repositoryCliente.findAll().stream().map(DtoClienteMostrar::new).toList());
    }

    @PostMapping("crear")
    public ResponseEntity crear(@RequestBody @Valid DtoCliente dtoCliente, UriComponentsBuilder uriComponentsBuilder){
        var cliente=repositoryCliente.save(new Cliente(dtoCliente));
        URI url= uriComponentsBuilder.path("cliente/unidad/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(url).body(new DtoClienteMostrar(cliente));

    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity actualizar(@PathVariable Long id,@RequestBody @Valid DtoActualizarCliente dtoActualizarCliente){
        var cliente = repositoryCliente.getReferenceById(id);
        cliente.actualizar(dtoActualizarCliente);
        return ResponseEntity.ok(new DtoClienteMostrar(cliente));
    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity borrar(@PathVariable Long id){
        var cliente = repositoryCliente.getReferenceById(id);
        repositoryCliente.delete(cliente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("unidad/{id}")
    public ResponseEntity unidad(@PathVariable Long id){
        var cliente=repositoryCliente.getReferenceById(id);
        return ResponseEntity.ok(new DtoClienteMostrar(cliente));
    }

}
