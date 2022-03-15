package com.exercise.system.exercisesystem.user.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "forum_user", indexes = @Index(columnList = "username", unique = true))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long userId;
    String username;
    String password;
    String salt;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    LocalDateTime lastSuccessfulLogin;
    LocalDateTime lastFailedLogin;
    boolean disabled;
    LocalDateTime disabledAt;
    boolean banned;
    LocalDateTime bannedAt;
    String banReason;
}
