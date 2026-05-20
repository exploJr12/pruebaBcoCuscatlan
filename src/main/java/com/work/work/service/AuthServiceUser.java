package com.work.work.service;

import com.work.work.domain.dto.user.DtoLogin;
import com.work.work.domain.dto.user.DtoRegister;
import com.work.work.domain.model.User;
import com.work.work.domain.repository.RepositoryUser;
import com.work.work.infra.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceUser {

    private final RepositoryUser repositoryUser;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public String register(DtoRegister dtoRegister){

        User user = new User(dtoRegister);

        user.setPassword(
                passwordEncoder.encode(dtoRegister.password())
        );

        repositoryUser.save(user);

        return "User registered successfully";
    }

    public String login(DtoLogin dtoLogin){

        User user = repositoryUser.findByEmail(dtoLogin.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean passwordMatches = passwordEncoder.matches(
                dtoLogin.password(),
                user.getPassword()
        );

        if(!passwordMatches){
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateToken(user.getEmail());
    }
}