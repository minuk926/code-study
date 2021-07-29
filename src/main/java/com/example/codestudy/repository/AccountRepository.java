package com.example.codestudy.repository;

import com.example.codestudy.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-29
 */
public interface AccountRepository extends JpaRepository<Account, Long>, QuerydslPredicateExecutor<Account> {
}
