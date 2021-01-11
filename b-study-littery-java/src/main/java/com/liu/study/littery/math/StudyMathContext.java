package com.liu.study.littery.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * 学习MathContext。
 *
 * MathContext：保存精度、舍入模式的一个对象，注意该类是被final修饰的。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/1/5 13:35
 */
public class StudyMathContext {

    public static void main(String[] args) {
        createObject();
    }

    /**
     * 如何创建MathContext。
     */
    public static void createObject() {
        /**
         * precision：精度；
         * roundingMode：舍入模式；
         */
        MathContext mathContext1 = new MathContext("precision=1 roundingMode=CEILING");

        /**
         * 方法二、
         */
        MathContext mathContext2 = new MathContext(2, RoundingMode.HALF_DOWN);

    }

    /**
     *
     */
    public static void basisMethod() {
        MathContext mathContext = new MathContext(2, RoundingMode.HALF_DOWN);
        final BigDecimal bigDecimal = new BigDecimal("56812.131212", mathContext);
        System.out.println(bigDecimal);
    }

}
