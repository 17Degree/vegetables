package com.auth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.auth.core.repository")
@ComponentScan({"com.security.config","com.user.*","com.user.base","com.user.core"})
public class AuthStart {

    public static void main(String[] args) {
        SpringApplication.run(AuthStart.class, args);
    }

}
