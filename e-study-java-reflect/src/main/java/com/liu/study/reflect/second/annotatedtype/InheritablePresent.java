package com.liu.study.reflect.second.annotatedtype;

import java.lang.annotation.*;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/1/4 13:15
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface InheritablePresent {
}
