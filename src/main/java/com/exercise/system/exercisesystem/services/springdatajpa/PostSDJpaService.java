package com.exercise.system.exercisesystem.services.springdatajpa;

import com.exercise.system.exercisesystem.model.Post;
import com.exercise.system.exercisesystem.repositories.PostRepository;
import com.exercise.system.exercisesystem.services.PostService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class PostSDJpaService implements PostService {

    private final PostRepository postRepository;

    public PostSDJpaService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Set<Post> findAll() {
        Set<Post> posts = new HashSet<>();
        postRepository.findAll().forEach(posts::add);
        return posts;
    }

    @Override
    public Post findById(UUID id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    @Override
    public void deleteById(UUID id) {
        postRepository.deleteById(id);
    }
}
