package com.example.codestudy.repository;

import com.example.codestudy.domain.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-22
 */
//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository extends MyRepository<Comment, Long>{

    @Nullable
    Comment findByComment(String title);

    List<Comment> findByTitleContains(String keyword);

    List<Comment> getByCommentLikeOrderByTitle(String comment, Pageable pageable);

    List<Comment> findByCommentContains(String keyword);
}
