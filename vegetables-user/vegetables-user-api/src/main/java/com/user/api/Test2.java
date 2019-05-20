package com.user.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.user.core.entity.User;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {


    public static void main(String[] args) {

        User user = User.Generator();


        user.setId(null);

        user.setDate(new Date());

        ObjectMapper objectMapper = new ObjectMapper();


        try {

            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm"));



            String s = objectMapper.writeValueAsString(user);


            System.out.println("user json 字符串：" + s);

            User user1 = objectMapper.readValue(s, User.class);


            System.out.println(user1);



            ObjectNode objectNode = objectMapper.createObjectNode();

            objectNode.put("name", "zhangsan");
            objectNode.put("age", 18);
            objectNode.putPOJO("ext", user1);


            String s1 = objectMapper.writeValueAsString(objectNode);

            System.out.println("node json 字符串：" + s1);


            JsonNode jsonNode = objectMapper.readTree("{\"name\":zhangsan,\"age\":18,\"ext\":null}");

            JsonNode jsonNode1 = jsonNode.get("name");
            JsonNode age11 = jsonNode.get("age");

            String s2 = jsonNode1.toString();

            long l = age11.asLong();


            System.out.println(s2);


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
