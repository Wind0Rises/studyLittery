package com.liu.study.littery.basis;

/**
 * int与Integer的区别。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/3/3 9:58
 */
public class IntAndInteger {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // firstTest();

        // secondTest();

        threeTest();

        // fourTest();
    }

    /**
     * 两个new出来的Integer是不相等的。
     */
    public static void firstTest() {
        Integer first = new Integer(155);
        Integer second = new Integer(155);
        System.out.println(first == second);            // false
        System.out.println(first.equals(second));       // true
    }

    /**
     * 任何一个Integer与int比较，只要值相等就相等。
     */
    public static void secondTest() {
        Integer second = new Integer(333);
        System.out.println(second == 333);
    }

    /**
     * 非new生成的Integer变量和new Integer生成的Integer变量比较的时候，结果为false
     */
    public static void threeTest() {
        Integer newInteger = new Integer(33);
        Integer directInteger = 33;
        System.out.println(newInteger == directInteger);        // false

        Integer newInteger1 = new Integer(333);
        Integer directInteger1 = 333;
        System.out.println(newInteger1 == directInteger1);      // false
    }

    /**
     * 两个非new出来的Integer对象，进行比较的时候，如果两个变量的值区间在-127~128之间的时候，则返回的结果为true，如果两个变量的变量值不在这个区间，则比较的结果为false。
     */
    public static void fourTest() {
        Integer firstDirect1 = 100;
        Integer firstDirect2 = 100;
        System.out.println(firstDirect1 == firstDirect2);   // true

        Integer secondDirect1 = 1000;
        Integer secondDirect2 = 1000;
        System.out.println(secondDirect1 == secondDirect2); //false
    }

    /**
     * 1. 自动装箱都是通过包装类的valueOf()方法来实现的
     * 2. 自动拆箱都是通过包装类对象的xxxValue()来实现的。
     */
    public static void binningAndBoxing() {
        Integer newInteger = 5;        // Integer integer = Integer.valueOf(5);
        int i = newInteger;            // int i = newInteger.intValue();
    }

}
