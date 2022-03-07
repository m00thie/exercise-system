package com.exercise.system.exercisesystem.services;

import com.exercise.system.exercisesystem.models.Room;
import com.exercise.system.exercisesystem.repositories.IRoomRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {
    private final IRoomRepository roomRepository;

    public RoomService(IRoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Optional<Room> findRoomById(Long id) { return roomRepository.findById(id);}

    public Room save(Room room) {
        return roomRepository.saveAndFlush(room);
    }
}
