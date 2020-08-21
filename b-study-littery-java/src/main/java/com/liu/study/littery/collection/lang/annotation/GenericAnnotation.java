package com.liu.study.littery.collection.lang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/17 12:45
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface GenericAnnotation {

    String test() default "";

}