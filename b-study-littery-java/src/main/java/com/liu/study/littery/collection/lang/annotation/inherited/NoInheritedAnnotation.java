package com.liu.study.littery.collection.lang.annotation.inherited;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/17 13:23
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoInheritedAnnotation {



}