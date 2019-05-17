package com.user;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.user.core.repository")
public class UserStart {

    public static void main(String[] args) {

        SpringApplication.run(UserStart.class, args);
    }

}
