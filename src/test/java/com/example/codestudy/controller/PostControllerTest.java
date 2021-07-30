package com.example.codestudy.controller;

import com.example.codestudy.domain.Post;
import com.example.codestudy.repository.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-30
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PostRepository postRepository;

    @BeforeEach
    void setUp() {
        int cnt = 1;
        while(cnt <= 100) {
            Post post = new Post();
            post.setTitle("test"+cnt);
            postRepository.save(post);
            cnt++;
        }
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPost() throws Exception{
        mockMvc.perform(get("/post/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(equalTo("test1")))
                .andExpect(content().string(containsString("test1")))
                ;
    }

    @Test
    void getPostsPage() throws Exception{
        mockMvc.perform(get("/post")
                        .param("page", "0")
                        .param("size", "10")
                        //.param("sort", "created, desc")
                        .param("sort", "title"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].title", is("test1")))
                ;
    }

    @Test
    void getHateoasPosts() throws Exception{
        mockMvc.perform(get("/posts")
                        .param("page", "3")
                        .param("size", "10")
                        //.param("sort", "created, desc")
                        .param("sort", "title"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.postList[0].id", is(36)))
        ;
    }
}