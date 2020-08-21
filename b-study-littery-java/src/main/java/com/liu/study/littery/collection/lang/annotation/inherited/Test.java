package com.liu.study.littery.collection.lang.annotation.inherited;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 只有在类上应用的Annotation才能被继承。
 * 除了类上应用的Annotation能被继承外，没有被重写的方法的Annotation也能被继承。当方法被重写后，Annotation将不会被继承。
 *
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/17 13:27
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Class<?> childClass = Class.forName("com.liu.study.littery.collection.lang.annotation.inherited.Child");

        Method[] declaredMethods = childClass.getMethods();

        List<String> methodNames = Arrays.asList("first", "second");

        for (Method item : declaredMethods) {
            String methodName = item.getName();
            if (methodNames.contains(methodName))  {
                Annotation[] annotations = item.getAnnotations();
                Stream.of(annotations).forEach(annotation -> {
                    System.out.println("方法名：" + methodName + " ,注解名：" + annotation.annotationType().getName());
                });
            }
        }

        System.out.println("#################################################################");
        Annotation[] annotations = childClass.getAnnotations();
        for (Annotation item : annotations) {
            System.out.println(item.toString());
        }
        System.out.println("结论：只用使用@Inherited注解的类，可以被子类集成，如果没有使用，者无法继承。");
    }

}