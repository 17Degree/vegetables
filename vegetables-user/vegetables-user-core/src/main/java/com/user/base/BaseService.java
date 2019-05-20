package com.user.base;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BaseService<T, ID> {

    public T findById(ID id);

    public List<T> findAll();

    public List<T> findAll(Sort sort);

    public List<T> findAllById(Iterable<ID> ids);

    public <S extends T> List<S> findAll(Example<S> example);

    public <S extends T> List<S> findAll(Example<S> example, Sort sort);

    public Page<T> findAll(Pageable pageable);

    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable);

    public <S extends T> long count(Example<S> example);

    public <S extends T> boolean exists(Example<S> example);

    public <S extends T> List<S> saveAll(Iterable<S> entities);

    public void deleteInBatch(Iterable<T> entities);
}
