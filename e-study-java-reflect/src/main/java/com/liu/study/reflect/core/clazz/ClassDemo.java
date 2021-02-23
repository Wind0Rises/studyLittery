package com.liu.study.reflect.core.clazz;


import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/17 14:55
 */
public class ClassDemo {


    /**
     * Class:
     *      1、类型判断：isEnum()、isPrimitive()、isInterface()...
     *      2、类操作：isAssignable()、getSuperclass()
     *      3、构造函数：
     *      4、字段：
     *      5、方法：getMethods()和getDeclaredMethods()的区别。
     *      6、注解：
     *      7、修饰符：
     *
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // firstTest();

        // secondTestIsAssignable();

        // castTest();

        // desiredAssertionStatusTest();

        // classForName();

        // getCanonicalNameTest();

        getClassesTest();
    }

    /**
     * isAssignable()和instanceOf的区别。
     *      isAssignable()：从类的角度去判断。判断类是否是给定类的父类。 类1.isAssignable(类2) --》 判断类1是否类2的父类。
     *      instanceOf：从实例的角度判断。 实例 instanceOf 类。
     */
    public static void secondTestIsAssignable() {

        boolean assignableFrom = List.class.isAssignableFrom(ArrayList.class);
        System.out.println(assignableFrom);

        boolean assignableFrom1 = ArrayList.class.isAssignableFrom(List.class);
        System.out.println(assignableFrom1);

        String li = "";
        Object object = new Object();
        System.out.println(li instanceof Object);

    }

    /**
     * 底层会先判断传入的参数是否为空，并且不是一个接口，
     * 然后就是强转。
     *
     * 等价(T) object;
     */
    public static void castTest() {

        InterfaceClass cast = InterfaceClass.class.cast(new ClassSuper());
        System.out.println(cast);

        /**
         * 不能把父类强转为子类。
         */
        ClassObject cast1 = ClassObject.class.cast(new ClassSuper());
        System.out.println(cast1);

    }

    /**
     * 【【不明白干啥的】】
     */
    public static void desiredAssertionStatusTest() {
        boolean b = ClassObject.class.desiredAssertionStatus();
        System.out.println(b);
    }

    /**
     *
     */
    public static void classForName() throws Exception {
        /**
         * class.forName(""):默认初始化类。
         */
        /*Class<?> aClass = Class.forName("com.liu.study.littery.collection.lang.clazz.OneObject");
        System.out.println(aClass);*/

        Class<?> initClass = Class.forName("com.liu.study.littery.collection.lang.clazz.OneObject", false, ClassDemo.class.getClassLoader());
        System.out.println(initClass);
    }

    /**
     * 获取类的全限定名
     *
     * 可以比较一下：getName、getSimpleName、getCanonicalName之间的却别，针对内部类、数组等等。
     */
    public static void getCanonicalNameTest() {
        String canonicalName = OneObject.class.getCanonicalName();
        System.out.println("canonicalName: " + canonicalName);
        String canonicalName1 = OneObject.InnerClass.class.getCanonicalName();
        System.out.println("innerCanonicalName:" + canonicalName1);
    }

    /**
     * getClasses()：获取该类已经以及父类中的所有public的内部了。
     * getDeclaredClasses()；获取该类中的所有内部类。包含该类的非public的类。
     */
    public static void getClassesTest() {
        Class<?>[] classes = OneObject.class.getClasses();

        if (classes.length > 0) {
            Stream.of(classes).forEach(li -> {
                System.out.println(li.getCanonicalName());
            });
        }

        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");

        Class<?>[] declaredClasses = OneObject.class.getDeclaredClasses();

        if (classes.length > 0) {
            Stream.of(declaredClasses).forEach(li -> {
                System.out.println(li.getCanonicalName());
            });
        }
    }

    /**
     * 类型判断。
     */
    public static void typeJudge() {

    }


    public static void firstTest() throws Exception {
        Class<?> aClass = Class.forName("com.liu.study.littery.collection.lang.clazz.ClassObject");
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
         * isPrimitive()：判断是否是基础（原始）类型。
         */
        System.out.println("-------------------------------");
        System.out.println(int.class.isPrimitive());
        System.out.println(boolean.class.isPrimitive());
        System.out.println(Boolean.TRUE.getClass().isPrimitive());
        System.out.println("8888888888888888888888888888888888888888888888888888");

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
         * native方法也会打印出来、会打印父类的final的方法。
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