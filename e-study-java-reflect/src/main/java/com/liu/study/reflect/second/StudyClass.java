package com.liu.study.reflect.second;

import com.liu.study.reflect.second.annotation.CustomAnnotation;
import com.liu.study.reflect.second.annotation.CustomAnnotationChildAnnotation;
import com.liu.study.reflect.second.annotation.CustomChildStudentAnnotation;
import com.liu.study.reflect.second.model.ChildFirstStudent;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
    public static void main(String[] args) throws Exception {
        /**
         * annotation相关的方法。
         */
        // testClassAnnotation();

        /**
         * method相关的方法
         */
        // testMethod();

        /**
         *
         */
        testField();
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
         * getDeclaredAnnotations()获取本类的所有注解。
         * <note>
         *     getAnnotations()和getDeclaredAnnotations()
         *          getAnnotations()：获取本类及其父类的。
         *          getDeclareAnnotations()：仅仅获取本来的注解。
         * </note>
         */
        Annotation[] declaredAnnotations = ChildFirstStudent.class.getDeclaredAnnotations();
        for (Annotation item : declaredAnnotations) {
            System.out.println("getDeclaredAnnotations()获取的值：" + item.toString());
        }





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
         * TODO：
         */
        CustomAnnotationChildAnnotation[] annotationsByType = ChildFirstStudent.class.getAnnotationsByType(CustomAnnotationChildAnnotation.class);
        for (CustomAnnotationChildAnnotation item : annotationsByType) {
            System.out.println("getAnnotationsByType()获取的：" + item.value());
        }
        System.out.println("\n\n");


        /**
         * isAnnotation()：是否是注解。
         */
        boolean isAnnotation = ChildFirstStudent.class.isAnnotation();
        System.out.println("isAnnotation()：" + isAnnotation);

        /**
         * 判断CustomAnnotationChildAnnotation这个注解是否在ChildFirstStudent上使用过。
         */
        boolean annotationPresent = ChildFirstStudent.class.isAnnotationPresent(CustomChildStudentAnnotation.class);
        System.out.println("isAnnotationPresent()获取的值为：" + annotationPresent);

    }


    /**
     *
     */
    public static void testMethod() throws Exception {
        /**
         * getMethod()：只能被public修饰的方法。本类/父类都会获取到，静态方法也可以获取到。
         */
        Method[] methods = ChildFirstStudent.class.getMethods();
        for (Method item : methods) {
            System.out.println("getMethods(): " + item.getName());
        }
        System.out.println();


        /**
         * getDeclaredMethods()：只能获取本类的方法，但是所有修饰符修饰的方法都是可以获取到的。静态方法也可以获取到。
         */
        Method[] declaredMethods = ChildFirstStudent.class.getDeclaredMethods();
        for (Method item : declaredMethods) {
            System.out.println("getDeclared()：" + item.getName());
        }
        System.out.println();

        /**
         * getMethod()；获取给定名称、给定参数的方法。如果没有获取到直接抛错。
         * <note>
         *     只能获取到public修饰的方法。
         * </note>
         */
        Method overloadTest1 = ChildFirstStudent.class.getMethod("overloadTest", String.class);
        System.out.println("getMethod()" + overloadTest1);
        Method overloadTest2 = ChildFirstStudent.class.getMethod("overloadTest", String.class, Integer.class);
        System.out.println("getMethod()" + overloadTest2);
        System.out.println();
        try {
            Method privateTest1 = ChildFirstStudent.class.getMethod("privateTest", String.class);
        } catch (Exception e) {
            System.err.println(e.toString());
        }



        /**
         *  <note>
         *      只能获取本类的方法，不管是用什么修饰符修饰的。
         *  </note>
         */
        Method privateTest = ChildFirstStudent.class.getDeclaredMethod("privateTest", String.class);
        System.out.println("getDeclaredMethod()：" + privateTest.getName());

    }

    /**
     *
     */
    public static void testField() throws Exception {
        /**
         * fields()：可以获取本类以及父类的public修饰的字段。
         */
        Field[] fields = ChildFirstStudent.class.getFields();
        for (Field item : fields) {
            System.out.println(item.getName());
        }
        System.out.println();

        Field[] declaredFields = ChildFirstStudent.class.getDeclaredFields();
        for (Field item : declaredFields) {
            System.out.println("declaredFields()：" + item.getName());
        }

        /**
         * <note>
         *      找不到方法会报错。
         * </note>
         */
        try {
            Field getDeclaredField = ChildFirstStudent.class.getDeclaredField("lisn");
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * 类型校验。
     */
    public static void judgeType() {

    }


    public static void test() {
        // ChildFirstStudent.class.cast();
        ChildFirstStudent.class.desiredAssertionStatus();
        // ChildFirstStudent.class.asSubclass()
        // ChildFirstStudent.class.asSubclass()
        // ChildFirstStudent.class.getCanonicalName();
        // ChildFirstStudent.class.getComponentType();
        // ChildFirstStudent.class.
    }

}
