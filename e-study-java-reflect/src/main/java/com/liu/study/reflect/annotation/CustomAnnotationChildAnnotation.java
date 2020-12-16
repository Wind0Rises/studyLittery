package com.liu.study.reflect.annotation;

import java.lang.annotation.*;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/12/15 19:58
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Inherited
@Documented
public @interface CustomAnnotationChildAnnotation {

    String value() default "";

}
