package com.exercise.system.exercisesystem.user.model.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Table(indexes = @Index(columnList = "name", unique = true))
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long permissionId;
    @Enumerated(EnumType.STRING)
    PermissionName name;
    String description;
}
