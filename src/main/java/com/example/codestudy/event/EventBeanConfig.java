package com.example.codestudy.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-29
 */
@Configuration
public class EventBeanConfig {

    @Bean
    public PostEventListener postEventListener(){
        return new PostEventListener();
    }

    @Bean
    public ApplicationListener<AccountPublishedEvent> accountEventListener(){
        return accountPublishedEvent -> {
            System.out.println("---------------------------------------------");
            System.out.println(accountPublishedEvent.getAccount()+" is published!!");
            System.out.println("---------------------------------------------");
        };
    }


}
