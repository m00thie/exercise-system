package com.exercise.system.exercisesystem.room.service;

import com.exercise.system.exercisesystem.room.model.Room;
import com.exercise.system.exercisesystem.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room createNewRoom(Room room) {
        room.setRoomId(null);
        room.setPrivateRoom(false);
        room.setCreatedAt(LocalDateTime.now());

        return roomRepository.save(room);
    }

    public Room getRoom(long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("No such room"));
    }
}
