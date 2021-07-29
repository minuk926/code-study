package com.example.codestudy;

import com.example.codestudy.domain.Account;
import com.example.codestudy.domain.Post;
import com.example.codestudy.event.AccountPublishedEvent;
import com.example.codestudy.event.EventBeanConfig;
import com.example.codestudy.event.PostPublishedEvent;
import com.example.codestudy.repository.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-29
 */
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
@ActiveProfiles("test")
@Import(EventBeanConfig.class)
public class SpringEventTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
 //       postRepository.deleteAll();
    }

    @Test
    public void eventTest() {
        Post post = new Post();
        post.setTitle("event published test");
        PostPublishedEvent event = new PostPublishedEvent(post);
        applicationContext.publishEvent(event);
    }

    @Test
    //@Rollback(value = false)
    public void eventTest2() {
        Post post = new Post();
        post.setTitle("event published test");
        //postRepository.save(post);
        postRepository.save(post.publish());
    }

    @Test
    //@Rollback(value = false)
    public void eventTest3() {
        Account account = new Account();
        account.setUsername("event published test");
        AccountPublishedEvent event = new AccountPublishedEvent(account);
        applicationContext.publishEvent(event);
    }
}
