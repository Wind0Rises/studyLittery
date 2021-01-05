package com.liu.study.reflect.annotatedtype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/1/4 13:08
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DirectlyPresent {

    int id();

    String description() default "this is a common description";

}
