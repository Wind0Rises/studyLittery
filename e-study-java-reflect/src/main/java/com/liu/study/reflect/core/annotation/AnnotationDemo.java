package com.liu.study.reflect.core.annotation;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/17 12:44
 */
@GenericAnnotation
@RepeatableAnnotationContainer({
        @RepeatableAnnotation(role = ""),
        @RepeatableAnnotation(role = "")
})
/**
 * 或者使用下面方式：
 */
/*@RepeatableAnnotation(role = "23")
@RepeatableAnnotation(role = "233")*/
public class AnnotationDemo {
}