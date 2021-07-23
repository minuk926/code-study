package com.example.codestudy.repository;

import com.example.codestudy.domain.Post;

import java.util.List;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-23
 */
public interface PostCustomRepository {
    List<Post> findMyPost();
}
