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
        // computeIfPresentTest(hashMap);

        /**
         *
         */
        // mergeTest(hashMap);

        /**
         *
         */
        putIfAbsent(hashMap);
    }

    /**
     * compute：
     *      在put操作的时候，都会执行function的内容，如果key存在，oldValue就是key对应的原始值
     *      如果key不存在，oldValue就为null。
     *
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
            System.out.println("------------  first  ------------");
            System.out.println("key：" + key + "，   oldValue：" + oldValue);
            return "we";
        });
        System.out.println(computeFirst);


        String second = hashMap.compute("second", (key, oldValue) -> {
            System.out.println("------------  second  ------------");
            System.out.println("key：" + key + "，   oldValue：" + oldValue);
            return "we";
        });
        System.out.println(second);
    }

    /**
     * absent【ˈæbsənt】 缺席的；缺少的；心不在焉的；茫然的
     *
     * computeIfAbsent
     *      如果key不存在，执行function中的语句。
     *      如果key存在，但是value为null的时候，执行function内容。
     *
     * @param hashMap
     */
    public static void computeIfAbsentTest(HashMap<String, String> hashMap) {
        String first = hashMap.computeIfAbsent("first", key -> {
            System.out.println(key);
            System.out.println("----------function 存在---------");
            return "---Key---";
        });
        System.out.println(first);

        String second = hashMap.computeIfAbsent("first11", key -> {
            System.out.println(key);
            System.out.println("----------function 不存在---------");
            return "---Key---";
        });
        System.out.println(second);

        hashMap.put("five", null);
        String five = hashMap.computeIfAbsent("five", key -> {
            System.out.println(key);
            System.out.println("----------  absent value is null ---------");
            return "---Key---";
        });
        System.out.println(five);
    }

    /**
     * present【ˈpreznt】：现在的；出席的；（事物）存在的；正在考虑的；现在时（态）的
     *      当key存在的时候，执行function中的内容。
     *
     */
    public static void computeIfPresentTest(HashMap<String, String> hashMap) {
        String firstKey = hashMap.computeIfPresent("first", (key, oldValue) -> {
            System.out.println(key);
            System.out.println(oldValue);
            System.out.println("----------  Present  function 存在   -------");
            return "----Vaule---";
        });
        System.out.println(firstKey);

        String second = hashMap.computeIfPresent("second--", (key, oldValue) -> {
            System.out.println(key);
            System.out.println(oldValue);
            System.out.println("----------  Present  function 不存在   -------");
            return "----Vaule---";
        });
        System.out.println(second);
    }

    /**
     * merge；
     *      如果Key存在，执行function内容。
     *
     * @param hashMap
     */
    private static void mergeTest(HashMap<String, String> hashMap) {
        /**
         *
         */
        String merge = hashMap.merge("key", "value", (key, value) -> {
            System.out.println("----------------  first  ----------------");
            System.out.println("key：" + key + "，value：" + value);
            return "we";
        });
        System.out.println(merge);

        /**
         *
         */
        String second = hashMap.merge("first", "first", (key, value) -> {
            System.out.println("---------------  second -----------------");
            System.out.println("key：" + key + "，value：" + value);
            return "we";
        });
        System.out.println(second);
    }

    /**
     * putIfAbsent：
     *      如果key存在，不进行put操作，直接返回原有的value，这时map中key对应的还是原有的value值，
     *      如果key不存在，和普通的put操作没有区别。
     *
     * @param hashMap
     */
    public static void putIfAbsent(HashMap<String, String> hashMap) {
        String five = hashMap.putIfAbsent("five", "five1");
        System.out.println(five);

        String first = hashMap.putIfAbsent("first", "first11");
        System.out.println(first);

        System.out.println(hashMap.get("first"));
    }

}