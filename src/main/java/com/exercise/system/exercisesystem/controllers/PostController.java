package com.exercise.system.exercisesystem.controllers;

import com.exercise.system.exercisesystem.models.Post;
import com.exercise.system.exercisesystem.models.Room;
import com.exercise.system.exercisesystem.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/post")
    public Post saveRoom(@RequestBody Post post) {
       return postService.save(post);
    }

    @GetMapping("/post/{id}")
    public Post getRoom(@PathVariable Long id) {
        Optional<Post> post = postService.findPostById(id);
        return post.orElseThrow(() -> new NoSuchElementException("Post with id : " + id + " does not exist"));
    }
}
