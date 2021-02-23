package com.liu.study.reflect.core.reflect;

import java.lang.annotation.*;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.util.stream.Stream;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/17 18:51
 */
public class ConstructorDemo {

    private String username;

    public ConstructorDemo() {

    }

    public ConstructorDemo(@ParameterAnnotation String username) {
        this.username = username;
    }

    public static void main(String[] args) {
        Class<ConstructorDemo> constructorDemoClass = ConstructorDemo.class;
        Constructor<?>[] declaredConstructors = constructorDemoClass.getDeclaredConstructors();
        Stream.of(declaredConstructors).forEach(item -> {
            AnnotatedType annotatedReceiverType = item.getAnnotatedReceiverType();
            Annotation[][] parameterAnnotations = item.getParameterAnnotations();
            for (Annotation[] annotations : parameterAnnotations) {
                for (Annotation annotation : annotations) {
                    System.out.println("annotation : " + annotation.toString());
                }
            }
            System.out.println(item.getAnnotatedReturnType().getType());
            System.out.println(annotatedReceiverType.getType());
        });
    }


    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    @interface ParameterAnnotation{

    }

}