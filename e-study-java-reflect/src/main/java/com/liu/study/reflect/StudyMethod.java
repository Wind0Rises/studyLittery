package com.liu.study.reflect;

import com.liu.study.reflect.annotation.ParameterAnnotation;
import com.liu.study.reflect.model.Student;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/12/16 22:51
 */
public class StudyMethod {


    /**
     * 通过{@link Student#totalStudentAge(String)}方法进行测试。
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Method totalStudentAgeMethod = Student.class.getMethod("totalStudentAge", String.class);

        /**
         * Annotation相关的。
         */
        testMethodAnnotation(totalStudentAgeMethod);
    }


    /**
     * Method中Annotation相关的方法。
     *
     * @param totalStudentAgeMethod
     * @throws Exception
     */
    public static void testMethodAnnotation(Method totalStudentAgeMethod) throws Exception {

        /**
         * 获取方法上的注解。
         */
        Annotation[] annotations = totalStudentAgeMethod.getAnnotations();
        for (Annotation item : annotations) {
            System.out.println("getAnnotations()：" + item.toString());
        }
        System.out.println();

        Annotation[] declaredAnnotations = totalStudentAgeMethod.getDeclaredAnnotations();
        for (Annotation item : declaredAnnotations) {
            System.out.println("getAnnotations()：" + item.toString());
        }
        System.out.println();

        /**
         * 获取给定方法给定注解类型的注解。
         * 如果没有会报错：NullPointerException
         */
        ParameterAnnotation annotation = totalStudentAgeMethod.getAnnotation(ParameterAnnotation.class);
        System.out.println("annotation：" + annotation);
        System.out.println();


        // totalStudentAgeMethod.getDeclaredAnnotation()


    }

}
