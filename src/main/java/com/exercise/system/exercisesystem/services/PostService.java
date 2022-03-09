package com.exercise.system.exercisesystem.services;

import com.exercise.system.exercisesystem.models.Post;
import com.exercise.system.exercisesystem.repositories.IPostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    private final IPostRepository postRepository;

    public PostService(IPostRepository postRepository) {this.postRepository = postRepository;}

    public Optional<Post> findPostById(Long id) { return postRepository.findById(id);}

    public Post save(Post post) {
        return postRepository.save(post);
    }
}
