package com.liu.study.littery.datatime;

import java.time.ZoneId;
import java.util.Map;
import java.util.Set;

/**
 * 时区
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/1/18 23:13
 */
public class ZoneIdTest {

    public static void main(String[] args) {
        /**
         * 创建ZoneId
         */
        createZoneId();

        /**
         * 获取所有时区
         */
        zoneAllDate();
    }

    public static void createZoneId() {
        /**
         * 获取指定时区。
         */
        ZoneId ctt = ZoneId.of("Asia/Shanghai");
        System.out.println(ctt);

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("系统默认时区：" + zoneId);

        final Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);
    }

    /**
     * 获取全部时区。
     */
    public static void zoneAllDate() {
        Map<String, String> shortIds = ZoneId.SHORT_IDS;
        shortIds.forEach((key, value) -> {
            System.out.println("key：" + key + "   value：" + value);
        });

        System.out.println(shortIds.keySet().size());
    }

}
