package com.exercise.system.exercisesystem.repositories;

import com.exercise.system.exercisesystem.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

    User findByLastName(String lastName);

    List<User> findAllByLastNameLike(String lastName);
}
