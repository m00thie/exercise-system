package com.exercise.system.exercisesystem.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DateTimeService {

    public LocalDateTime getCurrentLocalDate() {
        return LocalDateTime.now();
    }
}
