package com.exercise.system.exercisesystem.post.service;

import com.exercise.system.exercisesystem.post.model.domain.Post;
import com.exercise.system.exercisesystem.post.model.dto.PostDto;
import com.exercise.system.exercisesystem.post.repository.PostRepository;
import com.exercise.system.exercisesystem.room.repository.RoomRepository;
import com.exercise.system.exercisesystem.service.DateTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final RoomRepository roomRepository;

    private final DateTimeService dateTimeService;

    public Post createPost(long roomId, PostDto post) {
        Post newPost = new Post();
        newPost.setContent(post.content());
        newPost.setRoom(roomRepository.getById(roomId));
        newPost.setCreatedAt(dateTimeService.getCurrentLocalDate());
        newPost.setVisible(true);
        return postRepository.save(newPost);
    }
}
