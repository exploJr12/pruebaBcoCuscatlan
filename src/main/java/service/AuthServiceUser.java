package service;

import com.work.work.domain.dto.user.DtoLogin;
import com.work.work.domain.dto.user.DtoRegister;
import com.work.work.domain.model.User;
import com.work.work.domain.repository.RepositoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceUser {

    private final RepositoryUser repositoryUser;

    public String register(DtoRegister dtoRegister){

        User user = new User(dtoRegister);

        repositoryUser.save(user);

        return "User registered successfully";
    }

    public String login(DtoLogin dtoLogin){

        return "Login successful";
    }
}