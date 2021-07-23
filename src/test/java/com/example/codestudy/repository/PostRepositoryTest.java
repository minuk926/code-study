package com.example.codestudy.repository;

//import org.junit.Test;
import com.example.codestudy.domain.Post;
import com.example.codestudy.repository.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
@ActiveProfiles("test")
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        postRepository.deleteAll();
    }

    @Test
    //@Rollback(value = false)
    public void crudRepository(){
        // Given
        Post post = new Post();
        post.setTitle("hello spring boot common");
        assertThat(post.getId() == null);

        // When
        Post newPost = postRepository.save(post);
        // Then
        assertNotNull(newPost.getId());

        // When
        List<Post> posts = postRepository.findAll();
        // Then
        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts).contains(newPost);

        // When
        Page<Post> page = postRepository.findAll(PageRequest.of(0, 10));
        // Then
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
    }

    @Test
    //@Rollback(value = false)
    public void customRepository(){
        Assert.notNull(null, "dddd");
        postRepository.findMyPost();
    }
}