package com.liu.study.littery.datatime;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/1/18 23:09
 */
public class LocalTimeTest {

    public static void main(String[] args) {
        /**
         * 创建ZoneId
         */
        crateLocalTime();

        /**
         * 获取LocalTime的组成部分。
         */
        getConstituentPart();
    }

    public static void crateLocalTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        /**
         * 获取任意时间
         */
        LocalTime ofLocalTime = LocalTime.of(16, 23, 59, 102);
        System.out.println(ofLocalTime);

        /**
         * 获取当前时间
         */
        LocalTime now = LocalTime.now(ZoneId.systemDefault());
        System.out.println("当前时间：" + now);

        /**
         * 系统常用常量时间
         */
        LocalTime max = LocalTime.MAX;
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalTime min = LocalTime.MIN;
        LocalTime noon = LocalTime.NOON;
        System.out.println("Max: " + max);
        System.out.println("Midnight: " + midnight);
        System.out.println("Min: " + min);
        System.out.println("Noon：" + noon);
    }

    /**
     * 获取组成部分。
     */
    public static void getConstituentPart() {
        LocalTime now = LocalTime.now(ZoneId.systemDefault());

        /**
         * 方法一、
         */
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        int nano = now.getNano();
        System.out.println("小时：" + hour + "，分钟：" + minute + "，秒：" + second + "，毫秒：" + nano);

        /**
         * 方法二
         */
        int hourOfDay = now.get(ChronoField.HOUR_OF_DAY);
        int minuteOfHour = now.get(ChronoField.MINUTE_OF_HOUR);
        int secondOfMinute = now.get(ChronoField.SECOND_OF_MINUTE);
        int nanoOfSecond = now.get(ChronoField.NANO_OF_SECOND);
        System.out.println("小时：" + hourOfDay + "，分钟：" + minuteOfHour + "，秒：" + secondOfMinute + "，毫秒：" + nanoOfSecond);
    }

    /**
     * 操作LocalTime，对时间进行增减操作。
     */
    public static void operatorLocalTime() {
        LocalTime now = LocalTime.now(ZoneId.systemDefault());
    }

}
