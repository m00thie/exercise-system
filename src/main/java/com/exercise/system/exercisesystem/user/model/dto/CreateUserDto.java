package com.exercise.system.exercisesystem.user.model.dto;

public record CreateUserDto(Long userId, String username, String password, String repeatedPassword) {
    public CreateUserDto(String username, String password, String repeatedPassword) {
        this(null, username, password, repeatedPassword);
    }
}
