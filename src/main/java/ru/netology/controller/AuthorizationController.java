package ru.netology.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.authorities.Authorities;
import ru.netology.service.AuthorizationService;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorizationController {

    private AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("login") String login, @RequestParam("password") String password) {
        return service.getAuthorities(login, password);
    }
}