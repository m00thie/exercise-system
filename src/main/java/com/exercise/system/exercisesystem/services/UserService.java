package com.exercise.system.exercisesystem.services;

import com.exercise.system.exercisesystem.models.User;
import com.exercise.system.exercisesystem.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserById(UUID id) { return userRepository.findById(id);}

    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }
}
