package com.exercise.system.exercisesystem.services;

import com.exercise.system.exercisesystem.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService extends CrudService<User, UUID> {
    User findByLastName(String lastName);

    List<User> findAllByLastNameLike(String lastName);
}
