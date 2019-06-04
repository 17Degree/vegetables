package com.user.config.security;


import com.user.core.entity.User;
import com.user.core.repository.UserRepository;
import com.user.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public CustomUserDetailsService(){
        logger.info("-----------------初始化：CustomUserDetailsService");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = userService.findAll(Example.of(new User(username))).stream().findFirst();

        if(!userOptional.isPresent()){
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        User user = userOptional.get();

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("user")));
    }
}
