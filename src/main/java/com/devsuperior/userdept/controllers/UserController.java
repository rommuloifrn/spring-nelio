package com.devsuperior.userdept.controllers;

import com.devsuperior.userdept.UserRepository;
import com.devsuperior.userdept.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired // injeção de dependencia
    private UserRepository repo;

    @GetMapping // avisa que eh um metodo GET
    public List<User> findAll() {
        return repo.findAll();
    }

    @GetMapping(value="/{id}")
    public User findById(@PathVariable Long id) {
        return repo.findById(id).get();
    }

    @PostMapping
    public User Insert(@RequestBody User user) {
        return repo.save(user);
    }
}
