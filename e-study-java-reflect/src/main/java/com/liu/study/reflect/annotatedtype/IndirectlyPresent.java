package com.liu.study.reflect.annotatedtype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/1/4 13:09
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface IndirectlyPresent {

    IndirectlyPresentValue[] value();

}
