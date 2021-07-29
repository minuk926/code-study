package com.example.codestudy.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-29
 */
//public class PostEventListener implements ApplicationListener<PostPublishedEvent> {
//    @Override
//    public void onApplicationEvent(PostPublishedEvent postPublishedEvent) {
//        System.out.println("---------------------------------------------");
//        System.out.println(postPublishedEvent.getPost()+" is published!!");
//        System.out.println("---------------------------------------------");
//    }
//}

public class PostEventListener {
    @EventListener
    public void onApplicationEvent(PostPublishedEvent postPublishedEvent) {
        System.out.println("---------------------------------------------");
        System.out.println(postPublishedEvent.getPost()+" is published!!");
        System.out.println("---------------------------------------------");
    }
}
