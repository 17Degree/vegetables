package com.user.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Enumeration;

@Controller
@RequestMapping("callback")
public class OauthCallbackController {

    private static final Logger logger = LoggerFactory.getLogger(OauthCallbackController.class);


    @ResponseBody
    @RequestMapping("temp1")
    public JSONObject temp1(HttpServletRequest request){

        JSONObject res = new JSONObject();


        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()){

            String name = headerNames.nextElement();

            String parameterValues = request.getHeader(name);

            logger.info(MessageFormat.format("header_name:{0}>>>header_value:{1}", name, parameterValues));

            res.put(name, parameterValues);

        }

        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()){

            String name = parameterNames.nextElement();
            String[] parameterValues = request.getParameterValues(name);

            logger.info(MessageFormat.format("param_name:{0}>>>param_value:{1}", name, parameterValues[0]));

            res.put(name, parameterValues[0]);
        }


        Cookie[] cookies = request.getCookies();

        if(cookies != null){

            Arrays.asList(cookies).stream().forEach(cookie -> logger.info(MessageFormat.format("cookie_name:{0}>>>cookie_value:{1}", cookie.getName(), cookie.getValue())));

        }

        return res;
    }


    @RequestMapping("temp2")
    public String temp2(HttpServletRequest request){

        return "0.0";
    }

}
