package com.exercise.system.exercisesystem.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public interface DomainService {

    private SecurityContext getSecurityContext() {
        return SecurityContextHolder.getContext();
    }

    default Authentication getAuthentication() {
        return getSecurityContext().getAuthentication();
    }
}
