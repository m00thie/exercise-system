package com.exercise.system.exercisesystem.room.service;

import com.exercise.system.exercisesystem.room.model.domain.Room;
import com.exercise.system.exercisesystem.room.model.dto.RoomDto;
import com.exercise.system.exercisesystem.room.repository.RoomRepository;
import com.exercise.system.exercisesystem.service.DateTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    private final DateTimeService dateTimeService;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room createNewRoom(RoomDto room) {
        Room newRoom = new Room();
        newRoom.setName(room.name());
        newRoom.setDescription(room.description());
        newRoom.setPrivateRoom(false);
        newRoom.setCreatedAt(dateTimeService.getCurrentLocalDate());

        return roomRepository.save(newRoom);
    }

    public Room getRoom(long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("No such room"));
    }
}
