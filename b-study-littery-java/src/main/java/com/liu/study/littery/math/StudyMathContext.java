package com.liu.study.littery.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * 学习MathContext
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/1/5 13:35
 */
public class StudyMathContext {

    public static void main(String[] args) {
        MathContext mathContext = new MathContext(2, RoundingMode.HALF_DOWN);
        final BigDecimal bigDecimal = new BigDecimal("56812.131212", mathContext);
        System.out.println(bigDecimal);
    }

}
