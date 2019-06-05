package com.user.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.text.MessageFormat;

public class Utils {

    private static final Logger logger = LoggerFactory.getLogger(Utils.class);


    public static <T> T dynamicObtainValue(Object o, String propertyName, Class<T> clazz, Object defaultVlaue){

        T value = (T) defaultVlaue;

        Class<?> targetClass = o.getClass();

        try {

            Field declaredField = targetClass.getDeclaredField(propertyName);

            declaredField.setAccessible(true);

            value = (T) clazz.getClass().cast(declaredField.get(o));

        } catch (NoSuchFieldException e) {
            logger.warn(MessageFormat.format("类{0}属性{1}不存在，获取失败", targetClass.getName(), propertyName));
        } catch (IllegalAccessException e) {
            logger.error(MessageFormat.format("类{0}属性{1}无权限访问，请检查访问修饰符", targetClass.getName(), propertyName));
        }
        return  value;
    }

}
