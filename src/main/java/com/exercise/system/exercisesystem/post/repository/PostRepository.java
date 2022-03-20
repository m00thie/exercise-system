package com.exercise.system.exercisesystem.post.repository;

import com.exercise.system.exercisesystem.post.model.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
