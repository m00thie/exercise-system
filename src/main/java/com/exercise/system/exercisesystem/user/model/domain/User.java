package com.exercise.system.exercisesystem.user.model.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

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
    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
            name = "user_permissions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    Set<Permission> permissions;
}
