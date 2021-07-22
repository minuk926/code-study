package com.example.codestudy.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
//@Builder
//@ToString
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    //@Transient
    @OneToMany(mappedBy = "post", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)  // CascadeType.ALL
    private Set<Comment> comments = new HashSet<>();

    public void addComment(Comment comment){
        this.comments.add(comment);
        comment.setPost(this);
    }

    public void removeComment(Comment comment){
        this.comments.remove(comment);
        comment.setPost(this);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                //", comments=" + comments +
                '}';
    }
}
