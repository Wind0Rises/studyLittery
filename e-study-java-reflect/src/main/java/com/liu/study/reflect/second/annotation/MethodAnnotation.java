package com.liu.study.reflect.second.annotation;

import java.lang.annotation.*;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/12/17 13:01
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target(ElementType.METHOD)
@Documented
public @interface MethodAnnotation {

    String value() default "";

}
