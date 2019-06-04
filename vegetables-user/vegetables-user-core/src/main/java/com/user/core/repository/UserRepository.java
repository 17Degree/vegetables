package com.user.core.repository;


import com.user.base.BaseRepository;
import com.user.core.entity.User;

import java.util.Optional;

//@Repository
public interface UserRepository extends BaseRepository<User, Long>{
    Optional<User> findUserById(Long userId);
}
