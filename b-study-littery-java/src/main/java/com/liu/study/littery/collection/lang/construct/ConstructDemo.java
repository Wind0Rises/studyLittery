package com.liu.study.littery.collection.lang.construct;

import java.lang.reflect.Constructor;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/9/24 15:01
 */
public class ConstructDemo {

    public static void main(String[] args) throws Exception {
        newInstanceTest();
    }

    public static void newInstanceTest() throws Exception {
        Constructor<ConstructObject> constructor = ConstructObject.class.getConstructor();
        ConstructObject constructObject = constructor.newInstance();
        System.out.println(constructObject);
    }
}