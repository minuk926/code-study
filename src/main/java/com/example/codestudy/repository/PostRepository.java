package com.example.codestudy.repository;

import com.example.codestudy.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    // SimpleJpaRepository 사용
}

//@Repository
//@Transactional
//public class PostRepository {
//
//    @PersistenceContext
//    EntityManager entityManager;
//
//    public Post add(Post post){
//        entityManager.persist(post);
//        return post;
//    }
//
//    public void delete(Post post){
//        entityManager.remove(post);
//    }
//
//    public List<Post> findAll(){
//        return entityManager.createQuery("SELECT p from Post p").getResultList();
//    }
//}
