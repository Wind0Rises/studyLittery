package com.liu.study.reflect.core.annotation.inherited;

import java.lang.annotation.*;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/17 13:23
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface HaveInheritedAnnotation {

    

}