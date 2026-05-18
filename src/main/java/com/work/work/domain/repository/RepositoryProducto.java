package com.work.work.domain.repository;

import com.work.work.domain.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProducto extends JpaRepository<Producto,Long> {
}
