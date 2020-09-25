package com.liu.study.littery.collection.lang.method;

import java.lang.reflect.Method;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/9/24 15:12
 */
public class MethodDemo {

    public static void main(String[] args) {
        Method[] methods = MethodObject.class.getMethods();
    }

}