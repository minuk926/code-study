package com.example.codestudy.domain;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CommentSpecs {

    public static Specification<Comment> isBest(){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.isTrue(root.get(Comment_.best));
    }

    public static Specification<Comment> isGood(){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get(Comment_.up), 10);
    }
}
