package com.exercise.system.exercisesystem.repositories;

import com.exercise.system.exercisesystem.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomRepository extends JpaRepository<Room, Long> { }
