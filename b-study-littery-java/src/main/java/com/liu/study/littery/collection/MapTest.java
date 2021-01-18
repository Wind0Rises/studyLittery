package com.liu.study.littery.collection;

import java.util.HashMap;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/6 17:38
 */
public class MapTest {

    private static HashMap<String, String> hashMap = new HashMap<>();

    public static void main(String[] args) {
        hashMap.put("first", "first");
        hashMap.put("second", "second");
        hashMap.put("three", "three");

        /**
         *
         */
        // computeTest(hashMap);

        /**
         *
         */
        // computeIfAbsentTest(hashMap);

        /**
         *
         */
        computeIfPresentTest(hashMap);
    }

    /**
     * compute
     */
    public static void computeTest(HashMap<String, String> hashMap) {
        /**
         * compute("first", (key, oldValue) -> {return c});
         *
         * 如果：“first”对应的key存在。
         * oldValue就有值。最后返回的是BiFunction的返回值。
         *
         */
        String computeFirst = hashMap.compute("firs1t", (key, oldValue) -> {
            System.out.println(key);
            System.out.println(oldValue);
            return "we";
        });
        System.out.println(computeFirst);
    }

    /**
     * absent【ˈæbsənt】 缺席的；缺少的；心不在焉的；茫然的
     *
     * computeIfAbsent
     *      如果key存在
     *
     * @param hashMap
     */
    public static void computeIfAbsentTest(HashMap<String, String> hashMap) {
        String first = hashMap.computeIfAbsent("first", key -> {
            System.out.println(key);
            return "---Key---";
        });
        System.out.println(first);

        String second = hashMap.computeIfAbsent("first11", key -> {
            System.out.println(key);
            return "---Key---";
        });
        System.out.println(second);
    }

    /**
     * present【ˈpreznt】：现在的；出席的；（事物）存在的；正在考虑的；现在时（态）的
     */
    public static void computeIfPresentTest(HashMap<String, String> hashMap) {
        String firstKey = hashMap.computeIfPresent("first", (key, oldValue) -> {
            System.out.println(key);
            System.out.println(oldValue);
            return "----Vaule---";
        });
        System.out.println(firstKey);


    }


}