package com.example.codestudy.repository.impl;

import com.example.codestudy.domain.Post;
import com.example.codestudy.repository.PostCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-23
 */
@Repository
@Transactional
public class PostCustomRepositoryImpl implements PostCustomRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Post> findMyPost() {
        System.out.println("~~~~~ Custom findMyPost ~~~~~");
        return entityManager.createQuery("SELECT p from Post p", Post.class).getResultList();
    }
}
