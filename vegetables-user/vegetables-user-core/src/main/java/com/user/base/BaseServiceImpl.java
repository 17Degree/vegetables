package com.user.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID>{

    @Autowired
    private BaseRepository<T, ID> repository;

    @Override
    public T findById(ID id) {
        return repository.findById(id).get();
    }
}
