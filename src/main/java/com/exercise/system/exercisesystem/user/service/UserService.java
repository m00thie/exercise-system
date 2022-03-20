package com.exercise.system.exercisesystem.user.service;

import com.exercise.system.exercisesystem.service.DateTimeService;
import com.exercise.system.exercisesystem.user.model.domain.Permission;
import com.exercise.system.exercisesystem.user.model.domain.PermissionName;
import com.exercise.system.exercisesystem.user.model.domain.User;
import com.exercise.system.exercisesystem.user.model.dto.CreateUserDto;
import com.exercise.system.exercisesystem.user.model.dto.PermissionDto;
import com.exercise.system.exercisesystem.user.repository.PermissionRepository;
import com.exercise.system.exercisesystem.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;

    private final DateTimeService dateTimeService;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    private void configureSetup() {
        if (permissionRepository.count() == 0) {
            createPermission(new PermissionDto(PermissionName.ROLE_ADMIN, "Admin"));
            createPermission(new PermissionDto(PermissionName.ROLE_USER, "User"));
            createPermission(new PermissionDto(PermissionName.ROLE_MODERATOR, "moderator"));
        }
        if (userRepository.count() == 0) {
            createAdminUser(new CreateUserDto("admin", "admin", "admin"));
        }
    }

    public Permission createPermission(PermissionDto permissionDto) {
        Permission newPermission = new Permission();
        newPermission.setName(permissionDto.name());
        newPermission.setDescription(permissionDto.description());
        return permissionRepository.save(newPermission);
    }

    public User createAdminUser(CreateUserDto userDto) {
        return createUser(userDto, PermissionName.ROLE_ADMIN);
    }

    private User createUser(CreateUserDto userDto, PermissionName basePermissionName) {
        User newUser = new User();
        newUser.setUsername(userDto.username());
        newUser.setPassword(passwordEncoder.encode(userDto.password()));
        newUser.setCreatedAt(dateTimeService.getCurrentLocalDate());

        Permission basePermission = permissionRepository.findPermissionByName(basePermissionName)
                        .orElseThrow(() -> new NoSuchElementException("No admin permission"));

        newUser.setPermissions(Collections.singleton(basePermission));

        return userRepository.save(newUser);
    }
}
