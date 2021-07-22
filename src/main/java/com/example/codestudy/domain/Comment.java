package com.example.codestudy.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String comment;

    private Integer likeCount;

    @ManyToOne
    private Post post;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
