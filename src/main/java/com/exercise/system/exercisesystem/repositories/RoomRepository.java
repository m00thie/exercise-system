package com.exercise.system.exercisesystem.repositories;

import com.exercise.system.exercisesystem.model.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoomRepository extends CrudRepository<Room, UUID> {
}
