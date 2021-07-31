package com.example.codestudy.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@NamedEntityGraph(
        name = "Comment.post",
        attributeNodes = @NamedAttributeNode("post")
)
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

    private int up;

    private int down;

    private boolean best;

    @ManyToOne(fetch = FetchType.LAZY)
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
