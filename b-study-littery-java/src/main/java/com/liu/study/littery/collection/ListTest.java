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
        // firstTest();
        collectionsListTest();
    }

    public static void firstTest() {
        /**
         * 保留两个集合的并集。
         */
        testList.retainAll(conList);
        System.out.println(testList);
        System.out.println(conList);
    }

    public static void collectionsListTest() {
        System.out.println(testList);

        Collections.reverse(testList);
        System.out.println(testList);

        Collections.shuffle(testList);
        System.out.println(testList);

        Collections.shuffle(testList);
        System.out.println(testList);

    }

}