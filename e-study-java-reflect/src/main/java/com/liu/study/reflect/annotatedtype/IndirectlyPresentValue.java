package com.liu.study.reflect.annotatedtype;

import java.lang.annotation.*;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/1/4 13:09
 */
@Retention(RetentionPolicy.RUNTIME )
@Target(ElementType.TYPE)
@Repeatable(IndirectlyPresent.class)
public @interface IndirectlyPresentValue {

    String name();

}
