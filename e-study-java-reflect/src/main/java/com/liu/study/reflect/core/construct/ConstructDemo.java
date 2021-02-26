package com.liu.study.reflect.core.construct;

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

    /**
     * 通过Construct进行反射创建对象，静态代码块、非静态代码块、无参构造函数都会被调用。
     *
     * @throws Exception
     */
    public static void newInstanceTest() throws Exception {
        Constructor<ConstructObject> constructor = ConstructObject.class.getConstructor();
        ConstructObject constructObject = constructor.newInstance();
        System.out.println(constructObject);
    }
}