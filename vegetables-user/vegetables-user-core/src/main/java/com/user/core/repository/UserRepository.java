package com.user.core.repository;


import com.user.base.BaseRepository;
import com.user.core.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Long>{
    Optional<User> findUserById(Long userId);
}
