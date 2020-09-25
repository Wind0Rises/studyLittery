package com.liu.study.littery.stream;

import com.sun.deploy.ui.DialogTemplate;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Collectors类的使用。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/21 9:09
 */
public class CollectorsDemo {

    /**
     * Collector:
     * supplier():创建一个新的返回容器。
     * accumulator():将新元素添加到返回容器中。
     * combiner():将两个容器合并成一个。
     * finisher()：
     */
    public static void main(String[] args) {
        // basisMethod();

        collectorsApi();
    }

    public static void basisMethod() {
        ArrayList<Integer> collect = Stream.of("1", "2", "3", "4").collect(() -> {
            ArrayList<Integer> strings = new ArrayList<>();
            return strings;
        }, (first, item) -> {
            first.add(Integer.valueOf(item));
            System.out.println("---------  " + item);

        }, (item, liu) -> {
            System.out.println("8888888888" + item);
            System.out.println("8888888888  " + liu);
        });
        System.out.println(collect);

        StringBuilder collect1 = Stream.of("1", "2", "3", "4").collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(collect1);


        /**
         * stream.collect() 的本质由三个参数构成,
         * 1. Supplier 生产者, 返回最终结果
         * 2. BiConsumer<R, ? super T> accumulator 累加器第一个参数是要返回的集合, 第二个参数是遍历过程中的每个元素,
         *    将流中每个被遍历的元素添加到集合中
         * 3. BiConsumer<R, R> combiner 合并器, 在有并行流的时候才会有用, 一个流时代码不会走到这里 将第二步遍历得到的
         *    所有流形成的list都添加到最终的list中, 最后返回list1
         */
        Stream<String> stream = Stream.of("hello", "world", "helloworld");
        List<String> listDetail = stream.collect(
                () -> {
                    ArrayList<String> arrayList = new ArrayList<>();
                    System.out.println("第一个list诞生, size: " + arrayList.size());
                    return arrayList;
                },
                (theList, item) -> {
                    System.out.println("第二个list的size: " + theList.size());
                    theList.add(item);
                },
                (list1, list2) -> {
                    System.out.println("第三个list1的size: " + list1.size());
                    System.out.println("第四个list2的size: " + list2.size());
                    list1.addAll(list2);
                }
        );
        System.out.println(listDetail);


        System.out.println("#############################################################");
        Map<String, List<String>> collect2 = Stream.of("1", "2", "3", "4").collect(() -> {
            Map<String, List<String>> listMap = new HashMap<>();
            return listMap;
        }, (first, item) -> {
            if (Integer.valueOf(item) > 2) {
                List<String> da = Optional.ofNullable(first.get("da")).orElse(new ArrayList<>());
                da.add(item);
                first.put("da", da);
            } else {
                List<String> xiao = Optional.ofNullable(first.get("xiao")).orElse(new ArrayList<>());
                xiao.add(item);
                first.put("xiao", xiao);
            }
        }, (item, liu) -> {
            System.out.println("8888888888" + item);
            System.out.println("8888888888  " + liu);
        });
        System.out.println(collect2);


        System.out.println("1111111111111111111111111111111111111111111111111111111111111111111111111111111");
        ArrayList<Integer> collect3 = Stream.of("1", "2", "3", "4", "5", "6").parallel().collect(() -> {
            ArrayList<Integer> strings = new ArrayList<>();
            return strings;
        }, (first, item) -> {
            first.add(Integer.valueOf(item));
            System.out.println("---------  " + item);

        }, (list1, list2) -> {
            System.out.println("list1 ： " + list1 + "  ;list2 ：" + list2);
            list1.addAll(list2);
        });
        System.out.println(collect3);
    }

    public static void collectorsApi() {
        /**
         * averagingDouble：求平均值。
         */
        Double collect = Stream.of("1", "2", "3", "4", "5").collect(Collectors.averagingDouble(item -> Integer.valueOf(item)));
        System.out.println(collect);


        /**
         * 合并元素。
         */
        String collect1 = Stream.of("1", "2", "3", "4", "5").collect(Collectors.joining());
        System.out.println(collect1);


        String collect2 = Stream.of("1", "2", "3", "4", "5").collect(Collectors.joining("-"));
        System.out.println(collect2);

        /**
         * 求元素个数。
         */
        Long collect3 = Stream.of("1", "2", "3", "4", "5", "100").collect(Collectors.counting());
        System.out.println(collect3);

        /**
         * 将Stream进行分组。返回一个Map<Object, List<Object>类型的Map。
         */
        Map<String, List<String>> collect4 = Stream.of("1", "2", "3", "4", "5", "3").collect(Collectors.groupingBy(item -> item + "_"));
        System.out.println(collect4);

        /**
         * groupingByConcurrent进行并行处理。groupingByConcurrent对顺序不支持，但是可以提高效率
         */
        ConcurrentMap<String, List<String>> collect5 = Stream.of("1", "2", "3", "4", "5", "3").collect(Collectors.groupingByConcurrent(item -> item + "_"));
        System.out.println(collect5);

    }
}