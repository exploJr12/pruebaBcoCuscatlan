package com.work.work.controller;

import com.work.work.domain.dto.user.DtoLogin;
import com.work.work.domain.dto.user.DtoRegister;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AuthServiceUser;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class ControllerAuth {

    private final AuthServiceUser authServiceUser;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody @Valid DtoRegister dtoRegister){

        return ResponseEntity.ok(
                authServiceUser.register(dtoRegister)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody @Valid DtoLogin dtoLogin){

        return ResponseEntity.ok(
                authServiceUser.login(dtoLogin)
        );
    }
}