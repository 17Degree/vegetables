package com.user.config;

import com.user.temp.User;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {

    @Bean
    public List<User> preloadUsers() {
        return Arrays.asList(new User("user1", "password1", true, false, false),
                new User("user2", "password2", false, false, false),
                new User("user3", "password3", true, true, false),
                new User("user4", "password4", true, false, true));
    }

    private List<User> getUser(String username) {
        return preloadUsers().stream().filter(user -> user.getUsername().equals(username)).collect(Collectors.toList());
    }

    private Optional<User> getUserOne(String username) {

        return preloadUsers().stream().filter(user -> user.getUsername().equals(username)).findAny();
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = getUserOne(username);

        if(!user.isPresent()){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), getAuthority());
    }

    private List getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
