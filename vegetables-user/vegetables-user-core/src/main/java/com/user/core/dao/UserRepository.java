package com.user.core.dao;


import com.user.base.BaseRepository;
import com.user.core.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

}
