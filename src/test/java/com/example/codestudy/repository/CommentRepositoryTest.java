package com.example.codestudy.repository;

import com.example.codestudy.domain.Comment;
import com.example.codestudy.repository.CommentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-22
 */
@DataJpaTest
//@ActiveProfiles("test")
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void test(){
        Comment comment = new Comment();
        comment.setComment("Hello Comment");
        comment.setTitle("Best comment");
        commentRepository.save(comment);

        List<Comment> all = commentRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
        assertThat(all.get(0).getComment()).isEqualTo("Hello Comment");

        Page<Comment> page = commentRepository.findAll(PageRequest.of(0,1));
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getContent().size()).isEqualTo(1);
        assertThat(page.getContent().get(0).getComment()).isEqualTo("Hello Comment");

        Comment comment1 = commentRepository.findByComment("100l");
        assertThat(comment1).isNull();

        Optional<Comment> commentOptional = commentRepository.findById(100l);
        assertThat(commentOptional).isEmpty();
        //commentOptional.orElse(new Comment());
        //commentOptional.orElseThrow(IllegalAccessException::new);

        //commentRepository.save(null);

        commentRepository.findByTitleContains("Best");

        List<Comment> hello = commentRepository.getByCommentLikeOrderByTitle("Hello Comment", PageRequest.of(0, 1));
        System.out.println(hello);
    }
}