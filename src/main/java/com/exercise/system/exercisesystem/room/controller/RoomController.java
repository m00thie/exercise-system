package com.exercise.system.exercisesystem.room.controller;

import com.exercise.system.exercisesystem.post.model.domain.Post;
import com.exercise.system.exercisesystem.post.model.dto.PostDto;
import com.exercise.system.exercisesystem.room.model.domain.Room;
import com.exercise.system.exercisesystem.room.model.dto.RoomDto;
import com.exercise.system.exercisesystem.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Comparator;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping({"/", "/room"})
    public String listRoomsView(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms().stream().map(RoomDto::ofEntity).toList());
        return "index";
    }

    @GetMapping("/room/create")
    public String createRoomView(Model model) {
        model.addAttribute("room", RoomDto.ofEntity(new Room()));
        return "create-room";
    }

    @PostMapping("/room/create")
    public RedirectView createNewRoom(@ModelAttribute RoomDto room) {
        Room savedRoom = roomService.createNewRoom(room);
        return new RedirectView(String.format("/room/%d", savedRoom.getRoomId()));
    }

    @GetMapping("/room/{roomId}")
    public String getRoomView(@PathVariable("roomId") long roomId, Model model) {
        Room room = roomService.getRoom(roomId);
        model.addAttribute("room", RoomDto.ofEntity(room));
        model.addAttribute("newPost", PostDto.ofEntity(new Post()));
        model.addAttribute("posts", room.getPosts().stream().map(PostDto::ofEntity).sorted(Comparator.comparing(PostDto::createdAt)).toList());
        return "room";
    }
}
