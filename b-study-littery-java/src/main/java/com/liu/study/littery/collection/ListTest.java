package com.liu.study.littery.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/6 16:29
 */
public class ListTest {

    private static List<String> testList = new ArrayList<>(Arrays.asList("liu", "zhang", "wang", "li"));

    private static List<String> conList = new ArrayList<>(Arrays.asList("lll", "zhang", "wang", "we"));

    public static void main(String[] args) {
        /**
         *
         */
        // firstTest();

        /**
         *
         */
        // collectionsListTest();

        /**
         * 交并集。
         */
        listUniqueAndIntersection();
    }

    public static void firstTest() {
        /**
         * 保留两个集合的并集。
         */
        testList.retainAll(conList);
        System.out.println(testList);
        System.out.println(conList);
    }

    /**
     *
     */
    public static void collectionsListTest() {
        System.out.println(testList);

        Collections.reverse(testList);
        System.out.println(testList);

        Collections.shuffle(testList);
        System.out.println(testList);

        Collections.shuffle(testList);
        System.out.println(testList);
    }

    /**
     * 集合的交并集操作。
     */
    public static void listUniqueAndIntersection() {
        List<String> basisList = new ArrayList<String>(){{
            add("liu");
            add("liu");
            add("liu");
            add("wei");
            add("an");
            add("------------");
        }};

        List<String> compare = new ArrayList<String>(){{
            add("liu");
            add("liu");
            add("an");
            add("zhan");
        }};

        /**
         * 判断compare集合中的元素是否都包含在basisList中。
         */
        boolean b = basisList.containsAll(compare);
        System.out.println(b);


        /**
         * 保留basisList中包含compare的元素信息。
         */
        boolean processResult = basisList.retainAll(compare);
        if (processResult) {
            System.out.println(basisList);
        }


    }

}