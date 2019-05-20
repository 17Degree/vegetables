package com.user;


import com.user.core.entity.User;
import com.user.core.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserStart.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Test1 {

    @Autowired
    private UserService userService;


    @Test
    public void t1(){


        User byId = userService.findById(1L);

        try(FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\chenjiacheng\\Desktop\\temp2\\1.txt");ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(byId);
            objectOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
