package com.exercise.system.exercisesystem.repositories;

import com.exercise.system.exercisesystem.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post, Long> {}
