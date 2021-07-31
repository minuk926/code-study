package com.example.codestudy.repository;

import com.example.codestudy.domain.Comment;
import com.example.codestudy.domain.CommentSummary;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Stream;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-22
 */
//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository extends MyRepository<Comment, Long>, JpaSpecificationExecutor<Comment>, QueryByExampleExecutor<Comment> {

    @Nullable
    Comment findByComment(String title);

    List<Comment> findByTitleContains(String keyword);

    List<Comment> getByCommentLikeOrderByTitle(String comment, Pageable pageable);

    List<Comment> findByCommentContainsIgnoreCase(String keyword);
    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String keyword, int likeCount);

    Stream<Comment> getByCommentContainsIgnoreCase(String comment);

    @Async
    ListenableFuture<List<Comment>> queryByCommentContainsIgnoreCase(String comment);

    @EntityGraph(attributePaths = {"post"})
    Optional<Comment> queryById(Long id);

    <T> List<T> findByPost_Id(Long id, Class<T> type);
}
