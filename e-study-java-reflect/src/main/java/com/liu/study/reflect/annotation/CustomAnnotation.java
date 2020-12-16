package com.liu.study.reflect.annotation;

import java.lang.annotation.*;

/**
 * 自定义的Annotation。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/12/15 13:57
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Inherited
@Documented
public @interface CustomAnnotation {

    String value() default "";

}
