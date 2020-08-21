package com.liu.study.littery.collection.lang;

import java.lang.reflect.*;
import java.util.stream.Stream;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/17 14:55
 */
public class ClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.liu.study.littery.collection.lang.ClassObject");
        System.out.println(aClass);
        System.out.println(aClass.toGenericString());
        System.out.println(aClass.getModifiers());
        System.out.println(aClass.isInterface());
        System.out.println(aClass.isArray());
        System.out.println(aClass.isPrimitive());
        System.out.println(aClass.isSynthetic());
        System.out.println(aClass.getName());
        System.out.println(aClass.getClassLoader());

        /**
         * 获取泛型类型。
         */
        TypeVariable<? extends Class<?>>[] typeParameters = aClass.getTypeParameters();
        for (TypeVariable item : typeParameters ) {
            System.out.println("TypeVariable == " + item.getName());
            System.out.println("TypeVariable == " + item.getTypeName());
            System.out.println("TypeVariable == " + item.getAnnotatedBounds());
        }

        /**
         * getSuperclass()：返回当前对象所表示的类的超类
         * getGenericSuperclass()：返回当前对象所表示的类的超类，泛型也会返回。
         */
        System.out.println("superClass is : " + aClass.getSuperclass().getName());
        System.out.println("generic super class is : " + aClass.getGenericSuperclass().getTypeName());

        System.out.println("object super class : " + Object.class.getSuperclass());
        System.out.println("object super class : " + Object.class.getGenericSuperclass());
        System.out.println("interface super class : " + InterfaceClass.class.getSuperclass());
        System.out.println("interface super class : " + InterfaceClass.class.getGenericSuperclass());
        System.out.println("primitive type super class : " + int.class.getSuperclass() + "  --  " +
                                byte.class.getSuperclass());

        System.out.println("-------------------------------------------------------------");
        System.out.println("package is :" + aClass.getPackage());
        Class<?>[] interfaces = aClass.getInterfaces();
        Stream.of(interfaces).forEach(item -> {
            System.out.println("interface is :" + item.getClass());
        });

        Type[] genericInterfaces = aClass.getGenericInterfaces();
        Stream.of(genericInterfaces).forEach(item -> {
            System.out.println("interface is :" + item.getTypeName());
        });

        /**
         * 针对数组的。
         */
        System.out.println("component is :" + aClass.getComponentType());

        Class<?>[] declaredClasses = aClass.getDeclaredClasses();
        System.out.println(declaredClasses.length);
        Stream.of(declaredClasses).forEach(item -> {
            System.out.println("declared class : " + item.getName());
        });

        System.out.println("simple Name :" + aClass.getSimpleName());
        System.out.println("type Name :" + aClass.getTypeName());

        System.out.println("canonical name " + aClass.getCanonicalName());


        System.out.println(" " + aClass.isMemberClass());

        System.out.println("*******************************************************");
        Class<?>[] classes = aClass.getClasses();
        System.out.println(classes.length);
        Stream.of(classes).forEach(Class::getName);

        /**
         * 只能获取public的字段。
         */
        Field[] fields = aClass.getFields();
        System.out.println(fields.length);
        Stream.of(fields).forEach(System.out::println);

        /**
         * 获取这个Class的所有public的method。包含父类的final修饰的public方法。
         * native方法也会打印出来、会答应父类的final的方法。
         */
        Method[] methods = aClass.getMethods();
        Stream.of(methods).forEach(System.out::println);

        /**
         * 获取所有方法，包括被public/private/protected等修饰的方法，也就是说获取这个类所有的普通方法，
         * 父类final修饰的方法，其实已经不属于子类了。
         *
         * 不会打印父类的final方法。
         */
        System.out.println("-------------------------------------------------------");
        Method[] declaredMethods = aClass.getDeclaredMethods();
        Stream.of(declaredMethods).forEach(System.out::println);

        System.out.println("======================================================");
        Constructor<?>[] constructors = aClass.getConstructors();
        Stream.of(constructors).forEach(System.out::println);


        System.out.println("------------------------------------------------------");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        Stream.of(declaredConstructors).forEach(System.out::println);

        /**
         * getConstructors()、getDeclaredConstructors():都会打印无参构造函数。
         */
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        Class<ClassSuper> classSuperClass = ClassSuper.class;
        Constructor<?>[] constructors1 = classSuperClass.getConstructors();
        Stream.of(constructors1).forEach(System.out::println);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        Constructor<?>[] declaredConstructors1 = classSuperClass.getDeclaredConstructors();
        Stream.of(declaredConstructors1).forEach(System.out::println);

        System.out.println(aClass.getAnnotatedSuperclass());


        System.out.println("##########################################################");
        /**
         * getEnclosingClass：获取对应Class对应的直接外部类。
         * getDeclaredClass：获取对应类Class对象。
         */
        Class<InnerClass> innerClassClass = InnerClass.class;
        System.out.println("enclosing ： " + innerClassClass.getEnclosingClass());
        System.out.println("Declared  : " + innerClassClass.getDeclaredClasses().toString());

        Class<InnerClass.InnerInnerClass> innerInnerClassClass = InnerClass.InnerInnerClass.class;
        System.out.println(innerInnerClassClass.getEnclosingClass());
        System.out.println(innerInnerClassClass.getDeclaredClasses().toString());
    }

    /**
     * PUBLIC               1
     * PRIVATE              2
     * PROTECTED            4
     * STATIC               8
     * FINAL                16
     * SYNCHRONIZED         32
     * VOLATILE             64
     * TRANSIENT            128
     * NATIVE               256
     * INTERFACE            512
     * ABSTRACT             1024
     * STRICT               2048
     */

    static class Lisle{

    }

    class InnerClass {

        class InnerInnerClass {

        }

    }


}