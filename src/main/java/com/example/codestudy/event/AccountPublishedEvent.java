package com.example.codestudy.event;

import com.example.codestudy.domain.Account;
import com.example.codestudy.domain.Post;
import org.springframework.context.ApplicationEvent;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-29
 */
public class AccountPublishedEvent extends ApplicationEvent {
    private final Account account;

    /**
     *
     * @param source Object
     */
    public AccountPublishedEvent(Object source) {
        super(source);
        this.account = (Account) source;
    }

    public Account getAccount() {
        return account;
    }
}
