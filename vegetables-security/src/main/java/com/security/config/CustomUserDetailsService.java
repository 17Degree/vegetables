package com.security.config;


import com.security.temp.Utils;
import com.user.core.entity.User;
import com.user.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Component
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserService userService;

    public CustomUserDetailsService(){
        logger.info("-----------------初始化：CustomUserDetailsService");
    }

    @Override
    @SuppressWarnings("ALL")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<User> users = userService.findAll(Example.of(new User(username)));

        if(users.isEmpty()){
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        // 如果用户列表为 null，说明查找用户功能出现异常，抛出 AuthenticationServiceException
        if (Objects.isNull(users)) {
            throw new AuthenticationServiceException(String.format("Searching user[%s] occurred error!", username));
        }
        // 如果用户列表为空，说明没有匹配的用户，抛出 UsernameNotFoundException
        if (users.size() == 0) {
            throw new UsernameNotFoundException(String.format("No qualified user[%s]!", username));
        }
        // 如果用户列表中不止一个匹配用户，说明系统中用户唯一性逻辑存在问题，抛出 ConflictAccountException
        if (users.size() > 1) {
            throw new RuntimeException(String.format("Conflict user[%s]", username));
        }


        // 获取用户列表中唯一的用户对象
        User user = users.get(0);

        Boolean enabled = Utils.dynamicObtainValue(user, "enable", Boolean.class, true);

        Boolean expired = Utils.dynamicObtainValue(user, "expired", Boolean.class, false);

        Boolean locked = Utils.dynamicObtainValue(user, "locked", Boolean.class, false);

        // 如果用户没有设置启用或禁用状态，或者用户被设为禁用，则抛出 DisabledException
        Optional<Boolean> enabledOptional = Optional.ofNullable(enabled);
        if (!enabledOptional.orElse(false)) {
            throw new DisabledException(String.format("User[%s] is disabled!", username));
        }
        // 如果用户没有过期状态或过期状态为 true 则抛出 AccountExpiredException
        Optional<Boolean> expiredOptional = Optional.ofNullable(expired);
        if (expiredOptional.orElse(true)) {
            throw new AccountExpiredException(String.format("User[%s] is expired!", username));
        }
        // 如果用户没有锁定状态或锁定状态为 true 则抛出 LockedException
        Optional<Boolean> lockedOptional = Optional.ofNullable(locked);
        if (lockedOptional.orElse(true)) {
            throw new LockedException(String.format("User[%s] is locked!", username));
        }


        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("user")));
    }
}
