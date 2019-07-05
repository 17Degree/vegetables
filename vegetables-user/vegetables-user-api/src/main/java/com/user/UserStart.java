package com.user;


import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserStart {

    public static void main(String[] args) {

        //SpringApplication.run(UserStart.class, args);

        aaa();
    }


    public static final  void aaa(){

        System.out.println("内联函数");
    }

}
