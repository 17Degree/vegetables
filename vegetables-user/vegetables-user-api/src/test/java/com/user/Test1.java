package com.user;


import com.user.core.entity.User;
import com.user.core.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserStart.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Test1 {

    @Autowired
    private UserService userService;


    @Test
    public void t1(){


        User userInfo1 = userService.findById(1L);

        System.out.println(userInfo1);

        User userInfo2 = userService.findUserById(2L);

        System.out.println(userInfo2);
    }


}
