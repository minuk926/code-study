package com.example.codestudy.repository;

//import org.junit.Test;
import com.example.codestudy.domain.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//@TestPropertySource("classpath:application-test.properties")
@ActiveProfiles("test")
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    EntityManager entityManager;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
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

    @Test
    //@Rollback(value = false)
    //@Transactional
    void saveTest(){
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post);  // persist
        assertThat(entityManager.contains(post)).isTrue();
        assertThat(entityManager.contains(savedPost)).isTrue();
        //noinspection ResultOfMethodCallIgnored
        assertThat(post == savedPost);

        Post postUpdate = new Post();
        postUpdate.setId(post.getId());
        postUpdate.setTitle("jpa2");
        Post updatedPost = postRepository.save(postUpdate);  // merge
        assertThat(entityManager.contains(postUpdate)).isFalse();
        assertThat(entityManager.contains(updatedPost)).isTrue();
        assertThat(updatedPost != postUpdate);

        List<Post> all = postRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    void query(){
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post);

        postRepository.findByTitle("jpa", Sort.by("title"));
        //postRepository.findByTitle("jpa", Sort.by("LENGTH(title)"));
        postRepository.findByTitle("jpa", JpaSort.unsafe("LENGTH(title)"));
        postRepository.findByTitle2(1l,"jpa");

        int update = postRepository.updateTitle(1l, "jpa update");
        assertThat(update).isEqualTo(1);

        Optional<Post> optionalPost = postRepository.findById(1l);
        assertThat(optionalPost.get().getTitle()).isEqualTo("jpa update"); // 실패 조회query가 실행되디 않는다 --> 트랜잭션이 끋나지 않아 flush 안됨
    }
}