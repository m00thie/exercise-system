package com.exercise.system.exercisesystem.room.controller;

import com.exercise.system.exercisesystem.room.model.Room;
import com.exercise.system.exercisesystem.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping({"/", "/room"})
    public String listRoomsView(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "index";
    }

    @GetMapping("/room/create")
    public String createRoomView(Model model) {
        model.addAttribute("room", new Room());
        return "create-room";
    }

    @PostMapping("/room/create")
    public RedirectView createNewRoom(@ModelAttribute Room room) {
        Room savedRoom = roomService.createNewRoom(room);
        return new RedirectView(String.format("/room/%d", savedRoom.getRoomId()));
    }

    @GetMapping("/room/{roomId}")
    public String getRoom(@PathVariable("roomId") long roomId, Model model) {
        Room room = roomService.getRoom(roomId);
        model.addAttribute("room", room);
        return "room";
    }
}
