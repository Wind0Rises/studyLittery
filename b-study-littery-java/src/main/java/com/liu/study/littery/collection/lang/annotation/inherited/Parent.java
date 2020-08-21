package com.liu.study.littery.collection.lang.annotation.inherited;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/17 13:25
 */
@NoInheritedAnnotation
@HaveInheritedAnnotation
public class Parent {

    @NoInheritedAnnotation
    @HaveInheritedAnnotation
    public void first() {

    }

    @NoInheritedAnnotation
    @HaveInheritedAnnotation
    public void second() {

    }
}