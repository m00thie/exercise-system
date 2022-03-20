package com.exercise.system.exercisesystem.user.model.dto;

import com.exercise.system.exercisesystem.user.model.domain.Permission;
import com.exercise.system.exercisesystem.user.model.domain.PermissionName;

public record PermissionDto(Long permissionId, PermissionName name, String description) {
    public PermissionDto(PermissionName name, String description) {
        this(null, name, description);
    }

    public static PermissionDto ofEntity(Permission entity) {
        return new PermissionDto(entity.getPermissionId(), entity.getName(), entity.getDescription());
    }
}
