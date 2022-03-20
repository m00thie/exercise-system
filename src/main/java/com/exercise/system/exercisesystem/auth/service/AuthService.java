package com.exercise.system.exercisesystem.auth.service;

import com.exercise.system.exercisesystem.service.DateTimeService;
import com.exercise.system.exercisesystem.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    private final DateTimeService dateTimeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username)
                .map(u -> new User(u.getUsername(), u.getPassword(), Collections.emptyList()))
                .orElseThrow(() -> new UsernameNotFoundException("User %s not exists".formatted(username)));
    }

    public void updateSuccessLoginTimestamp(String username) {
        userRepository.findUserByUsername(username)
                .ifPresent(user -> {
                    user.setLastSuccessfulLogin(dateTimeService.getCurrentLocalDate());
                    userRepository.save(user);
                });
    }

    public void updateFailureLoginTimestamp(String username) {
        userRepository.findUserByUsername(username)
                .ifPresent(user -> {
                    user.setLastFailedLogin(dateTimeService.getCurrentLocalDate());
                    userRepository.save(user);
                });
    }
}
