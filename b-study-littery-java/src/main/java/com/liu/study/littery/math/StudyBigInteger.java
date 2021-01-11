package com.liu.study.littery.math;

import java.math.BigInteger;

/**
 *
 * 学习BigInteger。
 *
 * 基本类型，最大的值是64位，如果超过64为的数字该如何计算呢？
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/1/5 11:36
 */
public class StudyBigInteger {

    public static void main(String[] args) {
        /**
         * 创建BigInteger。
         */
        createBigIntegerObject();
    }

    /**
     * 创建BigInteger。
     */
    public static void createBigIntegerObject() {
        byte[] bytes = new byte[]{1, 2, 3};
        BigInteger bigInteger1 = new BigInteger(bytes);
        System.out.println(bigInteger1);

        /**
         * 第一个参数：
         * 第二个参数：进制
         */
        BigInteger bigInteger2 = new BigInteger("1073", 8);
        System.out.println("输出是按照十进制输出的：" + bigInteger2);
    }



}
