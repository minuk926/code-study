package com.example.codestudy.controller;

import com.example.codestudy.domain.Post;
import com.example.codestudy.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("ALL")
@RestController
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable("id") Post post){
        return postRepository.findById(post.getId()).get();
    }
}
