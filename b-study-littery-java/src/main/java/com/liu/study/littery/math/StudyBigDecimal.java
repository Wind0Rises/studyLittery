package com.liu.study.littery.math;

import java.math.BigDecimal;

/**
 * 学习BigDecimal。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/1/5 11:26
 */
public class StudyBigDecimal {

    public static void main(String[] args) {
        // BigDecimal
        BigDecimal bigDecimal = new BigDecimal("12");

        mattersNeedAttention();
    }

    /**
     * 需要注意的事项
     */
    public static void mattersNeedAttention() {
        BigDecimal first = new BigDecimal(10.511);
        System.out.println(first);

        BigDecimal second = new BigDecimal("10.511");
        System.out.println(second);

        System.out.println("-----------------------------------------------");
        BigDecimal a = new BigDecimal("1.2");
        a.add(new BigDecimal("1.4"));
        System.out.println(a);
    }

}
