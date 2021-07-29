package com.example.codestudy.event;

import com.example.codestudy.domain.Post;
import org.springframework.context.ApplicationEvent;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-29
 */
public class PostPublishedEvent extends ApplicationEvent {
    private final Post post;

    /**
     *
     * @param source Object
     */
    public PostPublishedEvent(Object source) {
        super(source);
        this.post = (Post)source;
    }

    public Post getPost() {
        return post;
    }
}
