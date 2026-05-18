package com.work.work.domain.model;

import com.work.work.domain.dto.user.DtoRegister;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    public User(DtoRegister request) {

        this.username = request.username();
        this.email = request.email();
        this.password = request.password();
    }

    public void update(DtoRegister request) {

        if(request.username() != null && !request.username().isBlank()) {
            this.username = request.username();
        }

        if(request.email() != null && !request.email().isBlank()) {
            this.email = request.email();
        }

        if(request.password() != null && !request.password().isBlank()) {
            this.password = request.password();
        }
    }
}