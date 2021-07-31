package com.example.codestudy.repository;

import com.example.codestudy.domain.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository {

    @Query("SELECT p FROM #{#entityName} p where p.title = :title")
    List<Post> findByTitle(@Param("title") String title, Sort sort);

    @Query("SELECT p FROM #{#entityName} p where p.id = :id and p.title = :title")
    List<Post> findByTitle2(@Param("id") Long id, @Param("title") String title);

    @Modifying(clearAutomatically = true)
    @Query("update #{#entityName} p set p.title = :title where p.id = :id")
    int updateTitle(@Param("id") Long id, @Param("title") String title);
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
