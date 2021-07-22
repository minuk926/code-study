package com.example.codestudy.runner;

import com.example.codestudy.domain.Post;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

//@Component
@Transactional
public class JpaQueryApplication implements ApplicationRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String sql = "SELECT p FROM Post as p";
        Query query = entityManager.createQuery(sql, Post.class);
        List<Post> posts = query.getResultList();
        posts.forEach(System.out::println);

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = builder.createQuery(Post.class);
        Root<Post> root = cq.from(Post.class);
        cq.select(root);

        List<Post> posts1 = entityManager.createQuery(cq).getResultList();
        posts1.forEach(System.out::println);

        // Native
        List<Post> posts2 = entityManager.createNativeQuery("Select * from Post", Post.class).getResultList();
        posts2.forEach(System.out::println);
    }
}
