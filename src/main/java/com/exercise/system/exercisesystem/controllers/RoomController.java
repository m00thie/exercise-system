package com.exercise.system.exercisesystem.controllers;

import com.exercise.system.exercisesystem.models.Room;
import com.exercise.system.exercisesystem.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class RoomController {
    @Autowired
    RoomService roomService;

    @PostMapping("/room")
    public Room saveRoom(@RequestBody Room room) {
        Room createdRoom = roomService.save(room);
        return createdRoom;
    }

    @GetMapping("/room/{id}")
    public Room getRoom(@PathVariable Long id) {
        Optional<Room> room = roomService.findRoomById(id);
        return room.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
