package com.exercise.system.exercisesystem.room.service;

import com.exercise.system.exercisesystem.room.model.domain.Room;
import com.exercise.system.exercisesystem.room.model.dto.RoomDto;
import com.exercise.system.exercisesystem.room.repository.RoomRepository;
import com.exercise.system.exercisesystem.service.DateTimeService;
import com.exercise.system.exercisesystem.service.DomainService;
import com.exercise.system.exercisesystem.user.model.domain.User;
import com.exercise.system.exercisesystem.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService implements DomainService {

    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    private final DateTimeService dateTimeService;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room createNewRoom(RoomDto room) {
        User creator = userRepository.getUserByUsername(getAuthentication().getName());
        Room newRoom = new Room();
        newRoom.setName(room.name());
        newRoom.setDescription(room.description());
        newRoom.setPrivateRoom(false);
        newRoom.setCreatedAt(dateTimeService.getCurrentLocalDate());
        newRoom.setCreatedBy(creator);

        return roomRepository.save(newRoom);
    }

    public Room getRoom(long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("No such room"));
    }
}
