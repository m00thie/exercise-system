package com.exercise.system.exercisesystem.post.model.dto;

import com.exercise.system.exercisesystem.post.model.domain.Post;
import com.exercise.system.exercisesystem.user.model.User;

import java.time.LocalDateTime;
import java.util.Optional;

public record PostDto(Long postId, String content, LocalDateTime createdAt, String author) {
    public static PostDto ofEntity(Post entity) {
        return new PostDto(
                entity.getPostId(),
                entity.getContent(),
                entity.getCreatedAt(),
                Optional.ofNullable(entity.getAuthor()).map(User::getUsername).orElse("")
        );
    }
}
