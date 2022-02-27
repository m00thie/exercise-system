package com.exercise.system.exercisesystem.services.springdatajpa;

import com.exercise.system.exercisesystem.model.User;
import com.exercise.system.exercisesystem.repositories.UserRepository;
import com.exercise.system.exercisesystem.services.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class UserSDJpaService implements UserService {
    private final UserRepository userRepository;

    public UserSDJpaService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    @Override
    public List<User> findAllByLastNameLike(String lastName) {
        return userRepository.findAllByLastNameLike(lastName);
    }
}
