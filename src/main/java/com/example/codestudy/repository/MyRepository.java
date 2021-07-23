package com.example.codestudy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-22
 */
@NoRepositoryBean
public interface MyRepository<T, ID extends Serializable> extends Repository<T, ID> {

    <E extends T> E save(@NonNull E entity);
    List<T> findAll();

    Iterable<T> findAll(Sort var1);

    Page<T> findAll(@NonNull Pageable var1);

    <E extends T> Optional<E> findById(ID id);

    void flush();

}
