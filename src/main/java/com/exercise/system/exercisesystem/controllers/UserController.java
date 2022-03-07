package com.exercise.system.exercisesystem.controllers;

import com.exercise.system.exercisesystem.models.User;
import com.exercise.system.exercisesystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        User userCreate = userService.save(user);
        return userCreate;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable UUID id) {
        Optional<User> user = userService.findUserById(id);
        return user.orElseThrow(() -> new NoSuchElementException("User with id : " + id + " does not found"));
    }
}
