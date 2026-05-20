package com.work.work.domain.repository;

import com.work.work.domain.model.Payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPayment
        extends JpaRepository<Payment, Long> {
}