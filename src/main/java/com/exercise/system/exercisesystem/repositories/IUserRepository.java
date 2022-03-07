package com.exercise.system.exercisesystem.repositories;

import com.exercise.system.exercisesystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {
    Optional<User> findById(UUID id);
}
