package com.work.work.domain.repository;

import com.work.work.domain.model.OrderDetail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryOrderDetail
        extends JpaRepository<OrderDetail, Long> {
}