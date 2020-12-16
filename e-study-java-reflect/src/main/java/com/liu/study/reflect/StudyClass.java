package com.liu.study.reflect;

import com.liu.study.reflect.annotation.CustomAnnotation;
import com.liu.study.reflect.annotation.CustomAnnotationChildAnnotation;
import com.liu.study.reflect.model.ChildFirstStudent;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;

/**
 * Class学习。
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/12/15 13:44
 */
public class StudyClass {

    /**
     *
     * Student（CustomAnnotation）
     *
     *     子类：ChildFirstStudent（CustomChildStudentAnnotation）
     *     子类：ChildSecondStudent（CustomChildStudentAnnotation、）
     */
    public static void main(String[] args) {
        testClassAnnotation();
    }


    /**
     * Annotation相关的测试。
     */
    public static void testClassAnnotation() {
        /**
         * getAnnotations()：获取类的所有注解，包括父类的。
         *                  这个获取是Annotation对象，并不是对应注解的对象。
         */
        Annotation[] annotations = ChildFirstStudent.class.getAnnotations();
        for (Annotation item : annotations) {
            System.out.println("getAnnotations()获取的AnnotationType：  " + item.annotationType());
        }
        System.out.println("\n\n");

        /**
         * getAnnotatedInterfaces()：干啥的？？TODO:
         */
        AnnotatedType[] annotatedInterfaces = ChildFirstStudent.class.getAnnotatedInterfaces();
        for (AnnotatedType item : annotatedInterfaces) {
            System.out.println("getAnnotatedInterfaces()获取的AnnotationType：  " + item);
        }
        System.out.println("\n\n");

        /**
         * getAnnotatedSuperclass()：干啥的？？TODO:
         */
        AnnotatedType annotatedSuperclass = ChildFirstStudent.class.getAnnotatedSuperclass();
        System.out.println("getAnnotatedSuperclass()获取的AnnotationType：  " + annotatedSuperclass);
        System.out.println("\n\n");




        /**
         * CustomAnnotation注解只在student类存在。
         * getAnnotation()获取给定注解的实例，如果本类有，就取本类的。如果本类没有，就取父类的。
         */
        CustomAnnotation annotation = ChildFirstStudent.class.getAnnotation(CustomAnnotation.class);
        System.out.println("getAnnotation()获取的Annotation：" + annotation + ".....注解的值：" + annotation.value());
        System.out.println("\n\n");

        /**
         * CustomAnnotation注解只在student类存在。
         * getDeclaredAnnotation()：获取本来的指定注解实例，如果本类有，取本类的；如果本来没有，父类有，返回null。
         * <note>
         *     getAnnotation()和getDeclaredAnnotation()区别：
         *          getAnnotation()：子类父类都可以取。
         *          和getDeclaredAnnotation()：只能去本类的。
         * </note>
         */
        CustomAnnotation declaredAnnotation = ChildFirstStudent.class.getDeclaredAnnotation(CustomAnnotation.class);
        if (declaredAnnotation != null) {
            System.out.println("getDeclaredAnnotation()获取的" + declaredAnnotation.value());
        }





        /**
         * TODO：不理解继承。
         */
        CustomAnnotationChildAnnotation[] annotationsByType = ChildFirstStudent.class.getAnnotationsByType(CustomAnnotationChildAnnotation.class);
        for (CustomAnnotationChildAnnotation item : annotationsByType) {
            System.out.println("getAnnotationsByType()获取的：" + item.value());
        }
        System.out.println("\n\n");


    }

}
