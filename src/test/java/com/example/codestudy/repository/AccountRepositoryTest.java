package com.example.codestudy.repository;

import com.example.codestudy.domain.Account;
import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-29
 */
@DataJpaTest
//@TestPropertySource("classpath:application-test.properties")
//@ActiveProfiles("test")
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void crud(){
//        QAccount qAccount = QAccount.account;
//        Predicate predicate = qAccount
//                .firstName.containsIgnoreCase("jonguk")
//                .and(qAccount.lastName.startsWith("lim"));
//
//        Optional<Account> one = accountRepository.findOne(predicate);
//        assertThat(one).isEmpty();
    }
}