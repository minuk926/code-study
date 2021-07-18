package com.example.codestudy;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//@Component
@Transactional
//@Slf4j
public class PostApplicationRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 생성
//        Post post = new Post();
//        post.setTitle("Spring Data JPA ....");
//
//        Comment comment = new Comment();
//        comment.setComment("quick quick....");
//        post.addComment(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setComment("as soon as..");
//        post.addComment(comment1);
//
//        Session session = entityManager.unwrap(Session.class);
//        session.save(post);


        // 삭제
//        Post load = session.get(Post.class, 1l);
//        session.delete(load);

        Session session = entityManager.unwrap(Session.class);
        Post post = session.get(Post.class, 1L);
        System.out.println("=====================================");
        System.out.println(post.getTitle());

        post.getComments().forEach(c -> {
            System.out.println("------------------------------------");
            System.out.println(c.getComment());
        });
        System.out.println("=====================================");

//        Session session = entityManager.unwrap(Session.class);
//        Comment comment = session.get(Comment.class, 2L);
//        System.out.println("=====================================");
//        System.out.println(comment.getComment());
//        System.out.println(comment.getPost().getTitle());
    }
}
