package com.liu.study.littery.collection.lang.annotation;

import java.lang.annotation.*;

/**
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/17 12:45
 */
@Repeatable(value = RepeatableAnnotationContainer.class)
public @interface RepeatableAnnotation {

    String role() default "";

}