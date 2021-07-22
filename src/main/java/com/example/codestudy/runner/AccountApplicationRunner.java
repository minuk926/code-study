package com.example.codestudy.runner;

import com.example.codestudy.domain.Account;
import com.example.codestudy.domain.Study;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//@Component
@Transactional
//@Slf4j
public class AccountApplicationRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Account account = new Account();
        account.setUsername("minuk");
        account.setPassword("jpa");

        Study study = new Study();
        study.setName("Spring Data Jpa");

        //Study에 ManyToOne 만 설정한 경우 - 관계설정을 Study 한 경우
        //study에 forign key로 account_id 생성
        //study.setAccount(account);

        //Account에 OneToMany 만 설정한 경우 - 관계설정을 Account에 한 경우
        // account_study 매핑테이블 생성
        //account.getStudies().add(study);


        //Account에 OneToMany Study에 ManyToOne 설정시
        //study(owner) 에 반드시 set
        account.getStudies().add(study);  // optional 이기는 하지만 필요
        study.setAccount(account);        // 필수

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);

        Account load = session.load(Account.class, account.getId());
        account.setUsername("minuk926");
        account.setUsername("minuk9264");
        System.out.println("===================================");
        System.out.println(load.getUsername());

    }
}
