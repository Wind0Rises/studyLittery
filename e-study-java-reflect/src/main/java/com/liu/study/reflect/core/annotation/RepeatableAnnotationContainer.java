package com.liu.study.reflect.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * RepeatableAnnotationContainer就相当于@RepeatableAnnotation容器。
 * {@link RepeatableAnnotation} 这个是真正的使用的注解，在这个注解要使用{@link java.lang.annotation.Repeatable}指明容器。
 * 注意：
 *      这个注解的必须有RepeatableAnnotation[] value();
 *      有一个value保存需要保存的注解。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/17 12:57
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatableAnnotationContainer {

    RepeatableAnnotation[] value();

}