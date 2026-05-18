package com.work.work.domain.repository;

import com.work.work.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCliente extends JpaRepository<Cliente,Long> {
    Cliente findByNombre(String nombre);
}
