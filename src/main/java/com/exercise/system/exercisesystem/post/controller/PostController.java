package com.exercise.system.exercisesystem.post.controller;

import com.exercise.system.exercisesystem.post.model.dto.PostDto;
import com.exercise.system.exercisesystem.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/room/{roomId}/post/create")
    public RedirectView createPost(@PathVariable("roomId") int roomId, @ModelAttribute PostDto post) {
        postService.createPost(roomId, post);
        return new RedirectView("/room/%d".formatted(roomId));
    }
}
