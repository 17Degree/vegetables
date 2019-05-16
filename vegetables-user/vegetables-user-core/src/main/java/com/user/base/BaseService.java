package com.user.base;

public interface BaseService<T, ID> {

    public T findById(ID id);
}
