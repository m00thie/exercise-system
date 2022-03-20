package com.exercise.system.exercisesystem.user.repository;

import com.exercise.system.exercisesystem.user.model.domain.Permission;
import com.exercise.system.exercisesystem.user.model.domain.PermissionName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Optional<Permission> findPermissionByName(PermissionName name);
}
