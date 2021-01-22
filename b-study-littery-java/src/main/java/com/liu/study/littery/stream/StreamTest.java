package com.liu.study.littery.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Liuweian
 * @version 1.0.0
 * @desc
 * @createTime 2020/8/15 12:25
 */
public class StreamTest {

    public static void main(String[] args) {

        /**
         * 创建Stream。
         */
        // createStream();

        /**
         * reduce：分解。
         */
        // reduceTest();

        /**
         *
         */
        // flatMapTest();

        /**
         * anyMatch()、allMatch()测试。
         */
         // matchTest();


        /**
         * 静态方法concat()方法。
         */
         concatTest();



    }

    /**
     *
     */
    public static void createStream() {
        /**
         * 通过generate()方法创建Stream。
         */
        Stream<String> stream1 = Stream.generate(() -> "love").limit(12);
        stream1.forEach(System.out::println);

        /**
         * 通过of()方法创建stream。
         */
        Stream<StreamObject> stream2 = Stream.of(new StreamObject[]{new StreamObject("liu"), new StreamObject("asdf")});
        stream2.forEach(System.out::println);
    }

    /**
     *
     */
    public static void reduceTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        ArrayList<StreamObject> objectList = new ArrayList<>();
        objectList.add(new StreamObject("1"));
        objectList.add(new StreamObject("2"));
        objectList.add(new StreamObject("3"));
        objectList.add(new StreamObject("4"));

        /**
         * T reduce(T identity, BinaryOperator<T> accumulator)
         *      identity：是遍历的第一条数据的入参，
         *      accumulator：
         *          第一入参：第一条数据是reduce的第一参数，以后的数据都是上一个accumulator运算的结果。
         *          第二入参：遍历的数据。
         */
        String reduce = list.stream().reduce("你的名字：", (first, second) -> {
            System.out.println("first：" + first + "....second：" + second);
            return first + second;
        });
        System.out.println(reduce + "\n\n");


        /**
         * reduce(BinaryOperator<T> accumulator)：
         *      第一次：第一个参数、第二参数就是stream（List）的第一、第二数据
         *      第n次：第一参数——上一次（n - 1）返回的结果；第二参数：stream（List）的（n + 1）次的数据。
         */
        System.out.println("------------------------------------------------------");
        Optional<String> reduceOptional = list.stream().reduce((first, second) -> {
            System.out.println("first：" + first + "    second：" + second);
            return first + second;
        });
        System.out.println("第二次测试--基本数据类型：" + reduceOptional.toString() + "\n");

        Optional<StreamObject> reduceStreamObject = objectList.stream().reduce((first, second) -> {
            System.out.println(first == second);
            System.out.println("first：" + first + "    second：" + second);
            first.setUsername(first.getUsername() + second.getUsername());
            return first;
        });
        System.out.println("第二次测试--对象：" + reduceStreamObject.get());

        /**
         * TODO：three、four的没有进行调用。
         */
        String reduceSpecial = list.stream().reduce("第一次默认数据：", (first, second) -> {
            System.out.println("first：" + first + "    second：" + second);
            return first + second;
        }, (three, four) -> {
            System.out.println("three：" + three + "    four：" + four);
            return "++++";
        });
        System.out.println("第三次测试--" + reduceSpecial);
    }

    /**
     * flatMap：
     *      复合Stream，flatMap入参的返回值也是一个Stream。
     *
     */
    public static void flatMapTest() {
        String[] tests = new String[]{"liuweian", "aesewesss"};
        List<String> collect = Stream.of(tests)
                .flatMap(item -> {
                    System.out.println("item ===> " + item);
                    Stream<String> split = Stream.of(item.split(""));
                    return split;
                })
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    /**
     * anyMatch：任务一个符合返回true；
     * allMatch：所有满足返回true；
     */
    public static void matchTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        boolean anyMatchResult = list.stream().anyMatch(item -> {
            return "1".equals(item);
        });
        System.out.println(anyMatchResult);

        boolean allMatchResult = list.stream().allMatch(item -> {
            return "1".equals(item);
        });
        System.out.println(allMatchResult);
    }


    /**
     * Stream的静态方法concat
     */
    public static void concatTest() {
        ArrayList<String> first = new ArrayList<>();
        first.add("1");
        first.add("2");

        ArrayList<String> second = new ArrayList<>();
        second.add("3");
        second.add("4");
        Stream<String> concat = Stream.concat(first.stream(), second.stream());
        concat.forEach(System.out::println);
    }

    /**
     * TODO:
     */
    public static void distinctTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static
    class StreamObject {

        private String username;

    }
}
