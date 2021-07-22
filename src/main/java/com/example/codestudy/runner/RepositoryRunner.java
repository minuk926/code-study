package com.example.codestudy.runner;

import com.example.codestudy.domain.Post;
import com.example.codestudy.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class RepositoryRunner implements ApplicationRunner {

    private final PostRepository postRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Post> posts = postRepository.findAll();
        posts.forEach(System.out::println);

    }
}
