package com.example.codestudy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-22
 */
@NoRepositoryBean
public interface MyRepository<T, Id extends Serializable> extends Repository<T, Id> {

    <E extends T> E save(E entity);
    List<T> findAll();

    Iterable<T> findAll(Sort var1);

    Page<T> findAll(Pageable var1);
}
