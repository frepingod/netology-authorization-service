package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorities.Authorities;
import ru.netology.model.User;

import java.util.Arrays;
import java.util.List;

import static ru.netology.authorities.Authorities.*;

@Repository
public class UserRepository {

    private List<User> users = Arrays.asList(
            new User("login1", "pass1", Arrays.asList(READ, WRITE, DELETE)),
            new User("login2", "pass2", Arrays.asList(READ, WRITE)),
            new User("login3", "pass3", List.of(DELETE))
    );

    public List<Authorities> getUserAuthorities(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user.getAuthorities();
            }
        }
        return null;
    }
}