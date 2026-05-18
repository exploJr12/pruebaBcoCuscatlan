package com.work.work.domain.repository;

import com.work.work.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryUser extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}