package com.example.codestudy;

//import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
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
}