package com.example.codestudy.repository;

import com.example.codestudy.domain.Comment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-22
 */
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
@ActiveProfiles("test")
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @BeforeAll
    static void init() {
    }

    @BeforeEach
    void setUp() {
        this.createdComment(100, "Spring date Jpa");
        this.createdComment(50, "HIBERNATE SPRING");
        this.commentRepository.flush();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    //@DependsOn()
    void repo_load() throws InterruptedException {
        commentRepository.findByCommentContainsIgnoreCase("spring");

        System.out.println("================== Async Call ==============================================");
        ListenableFuture<List<Comment>> future = commentRepository.queryByCommentContainsIgnoreCase("sPring");
        System.out.println("============================================================================");
        future.addCallback(new ListenableFutureCallback<List<Comment>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(throwable.getLocalizedMessage());
            }

            @Override
            public void onSuccess(List<Comment> comments) {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>is done?" + future.isDone());
                System.out.println(">>>>>>>>>>>>>>>>>> Async >>>>>>>>>>>>>>>>>>>>>>");
                comments.forEach(System.out::println);
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            }
        });

        commentRepository.findByCommentContainsIgnoreCaseAndLikeCountGreaterThan("spring", 50);

        try(Stream<Comment> commentStream = commentRepository.getByCommentContainsIgnoreCase("sPring");) {
            Comment comment = commentStream.findFirst().get();
            assertThat(comment.getLikeCount()).isEqualTo(100);
        }
        Thread.sleep(5000);

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

    void createdComment(int likeCount, String cmt){
        Comment comment = new Comment();
        comment.setLikeCount(likeCount);
        comment.setComment(cmt);
        commentRepository.save(comment);
    }
}