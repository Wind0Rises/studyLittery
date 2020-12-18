package com.liu.study.reflect;

import com.liu.study.reflect.annotation.ParameterAnnotation;
import com.liu.study.reflect.model.Student;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/12/16 22:51
 */
public class StudyMethod {

    /**
     * TODO：不懂的
     *
     *
     * getDefaultValue()
     */


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
        // testMethodAnnotation(totalStudentAgeMethod);

        /**
         *
         */
        // stest(totalStudentAgeMethod);

        /**
         * 方法参数相关的。
         */
        testParameter(totalStudentAgeMethod);
    }


    /**
     * Method中Annotation相关的方法。
     * <note>
     *     TODO: getDeclaredAnnotation()与getAnnotation()方法的区别。
     * </note>
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


        Annotation[][] parameterAnnotations = totalStudentAgeMethod.getParameterAnnotations();
        int index = 1;
        for (Annotation[] item : parameterAnnotations) {
            System.out.println("------      第" + index + "个参数   ---------");
            for (Annotation bean : item) {
                System.out.println("Annotation of Method Parameter" + bean);
            }
            index++;
        }
        System.out.println();

    }

    /**
     *
     * @param totalStudentAgeMethod
     * @throws Exception
     */
    public static void test(Method totalStudentAgeMethod) throws Exception {

        Class<?> declaringClass = totalStudentAgeMethod.getDeclaringClass();
        System.out.println(declaringClass);

        Object defaultValue = totalStudentAgeMethod.getDefaultValue();
        System.out.println(defaultValue);

        Class<?>[] exceptionTypes = totalStudentAgeMethod.getExceptionTypes();
        for (Class item : exceptionTypes) {
            System.out.println(item);
        }
    }

    /**
     *
     * @param totalStudentAgeMethod
     * @throws Exception
     */
    public static void testParameter(Method totalStudentAgeMethod) throws Exception {
        /**
         * 获取参数数量
         */
        int parameterCount = totalStudentAgeMethod.getParameterCount();
        System.out.println("getParameterCount()：" + parameterCount);
    }

}
