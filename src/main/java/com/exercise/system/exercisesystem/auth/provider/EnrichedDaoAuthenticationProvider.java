package com.exercise.system.exercisesystem.auth.provider;

import com.exercise.system.exercisesystem.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@RequiredArgsConstructor
public class EnrichedDaoAuthenticationProvider extends DaoAuthenticationProvider {

    private final AuthService authService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            Authentication auth = super.authenticate(authentication);

            authService.updateSuccessLoginTimestamp(auth.getName());

            return auth;
        } catch (BadCredentialsException e) {
            authService.updateFailureLoginTimestamp(authentication.getName());
            throw e;
        }
    }
}
