package com.liu.study.littery.datatime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 *
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/1/18 23:09
 */
public class LocalTimeTest {

    public static void main(String[] args) {
        /**
         * 创建ZoneId
         */
        // crateLocalTime();

        /**
         * 获取LocalTime的组成部分。
         */
        // getConstituentPart();

        /**
         * 增减小时、分钟、秒、纳秒。
         */
        // operatorLocalTime();

        /**
         * LocalTime相互之间比较
         */
        localTimeCompareTo();
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
        System.out.println("操作前的数据：" + now);

        /**
         * 会产生一个新对象，原有对象不改变。
         */
        LocalTime plusHours = now.plus(1, ChronoUnit.HOURS);
        System.out.println("小时增加1小时：" + plusHours);


        /**
         * 会产生一个新对象，原有对象不改变。
         */
        LocalTime plusMinutes = now.plus(1, ChronoUnit.MINUTES);
        System.out.println("分钟增加1小时：" + plusMinutes);

        /**
         * 会产生一个新对象，原有对象不改变。
         */
        LocalTime plusSecond = now.plus(1, ChronoUnit.SECONDS);
        System.out.println("秒增加1小时：" + plusSecond);

        /**
         * 会产生一个新对象，原有对象不改变。
         */
        LocalTime plusNanos = now.plus(1, ChronoUnit.NANOS);
        System.out.println("秒增加1小时：" + plusNanos);

        /**
         * 超额增加分钟显示。会影响到小时字段。
         */
        LocalTime plusSuperMinutes = now.plus(133, ChronoUnit.MINUTES);
        System.out.println("超额增加分钟显示：" + plusSuperMinutes);


        /**
         * ################################  方法二  ######################
         */
        Duration duration = Duration.ofHours(2L);
        LocalTime plusDurationHour = now.plus(duration);
        System.out.println(plusDurationHour);
    }

    /**
     * 时间之间的比较。
     */
    public static void localTimeCompareTo() {
        LocalTime now = LocalTime.now(ZoneId.systemDefault());
        System.out.println("操作前的数据：" + now);

        LocalTime before = now.plusHours(-2L);
        System.out.println("以前的时间：" + before);
        LocalTime after = now.plusHours(2L);
        System.out.println("以后的时间：" + after);

        /**
         * 负值：小于指定的时间。当前时间在给定的时间以前。
         * 正值；大于指定的时间。当前时间在给定的时间以后。
         */
        final int compareTo = before.compareTo(after);
        System.out.println(compareTo);

        /**
         * 看这个时间是否在给定时间之后。
         */
        boolean isAfterResult = before.isAfter(after);
        System.out.println(isAfterResult);

        /**
         * 看这个时间是否在给定时间之前。
         */
        boolean isBeforeResult = before.isBefore(after);
        System.out.println(isBeforeResult);

    }

}
