package com.liu.study.reflect.core.clazz;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/9/24 13:41
 */
public class OneObject {

    /**
     *
     * 它是随着【类】的加载而执行，只执行一次。
     * 静态代码块其实就是给【类】初始化的，而构造代码块是给【对象】初始化的。
     *
     * 静态代码块；
     * 构造函数：
     *
     *
     */
    static {
        System.out.println("  this is OneObject static code lump，这是静态代码块 ");
    }

    public static String li = null;

    public OneObject() {
        System.out.println("-----------  初始化了 ----------");
        li = "zhangsan";
    }

    public String getLi() {
        return li;
    }

    public static class InnerClass {

    }

    private class MainPrivate {

    }

    private static class PriInnerClass {

    }

}