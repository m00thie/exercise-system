package com.exercise.system.exercisesystem.room.repository;

import com.exercise.system.exercisesystem.room.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
