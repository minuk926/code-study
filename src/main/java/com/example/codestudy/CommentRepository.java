package com.example.codestudy;

import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-22
 */
//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository extends MyRepository<Comment, Long>{
}
