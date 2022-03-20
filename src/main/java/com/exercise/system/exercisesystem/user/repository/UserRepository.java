package com.exercise.system.exercisesystem.user.repository;

import com.exercise.system.exercisesystem.user.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
