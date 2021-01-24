package com.liu.study.littery.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Liuweian
 * @version 1.0.0
 * @desc
 * @createTime 2020/8/15 12:25
 */
public class StreamTest {


    /**
     * <note>
     * 有时候需要在遍历中途停止操作，比如查找第一个满足条件的元素或者limit操作。在Stream中short-circuiting操作有：anyMatch、allMatch、noneMatch、
     * findFirst、findAny、limit，这些操作在Sink中都有一个变量来判断是否短路，比如limit用的是m，match用的是stop，find用的是hasValue。
     * </note>
     *
     * @param args
     */
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
         * flatMap：将一个对象Stream，然后把对象里的元素在Stream，最后操作。类似List包含List操作。
         */
        // flatMapTest();

        /**
         * anyMatch()、allMatch()、noonMatch()测试：判断Stream是否包含指定元素、或者是否是全部瞒住条件。
         */
         // matchTest();

        /**
         * 静态方法concat()方法：将两个stream合并成一个Stream。
         */
         // concatTest();

        /**
         * 过滤操作。
         */
        // distinctTest();

        /**
         *
         */
        // findTest();

        /**
         * forEach：
         * forEachOrdered：在parallel模式下依旧保证顺序性。
         */
        // forEachTest();

        /**
         *
         */
        // limitTest();

        /**
         *
         */
        // extremityTest();

        /**
         *
         */
        // peekTest();

        /**
         *
         */
        skipTest();
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

        boolean noonMatchFirst = list.stream().noneMatch(item -> {
            return "2".equals(item);
        });
        System.out.println(noonMatchFirst);

        boolean noonMatchSecond = list.stream().noneMatch(item -> {
            return "12".equals(item);
        });
        System.out.println(noonMatchSecond);
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
     * distinct操作：
     */
    public static void distinctTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("2");
        List<String> distinctResult = list.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctResult);
    }

    /**
     * findAny：可以看到findAny()操作，返回的元素是不确定的，对于同一个列表多次调用findAny()有可能会返回不同的值。
     *         使用findAny()是为了更高效的性能。如果是数据较少，串行地情况下，一般会返回第一个结果，如果是并行的情况，那就不能确保是第一个。
     * findFirst：
     */
    public static void findTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("2");

        String findAnyResult1 = list.stream().findAny().get();
        String findAnyResult2 = list.stream().findAny().get();
        String findFirstResult = list.stream().findFirst().get();
        System.out.println("findAny：" + findAnyResult1 + "   、" +findAnyResult2);
        System.out.println("findFirst：" + findFirstResult);
    }

    /**
     * forEachOrdered():在并发场景下的保证顺序。
     */
    public static void forEachTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");

        list.stream().parallel().forEach(System.out::println);
        System.out.println("------------------------------");
        list.stream().parallel().forEachOrdered(System.out::println);
    }

    /**
     * limit测试：
     */
    public static void limitTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        list.add("DDD");
        list.add("EEE");
        list.add("FFF");
        list.add("GGG");
        List<String> limitList = list.stream().limit(2).collect(Collectors.toList());
        System.out.println(limitList);
    }


    /**
     * 极限测试：min()、max()
     */
    public static void extremityTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer max = list.stream().max(Comparator.comparingInt(item -> item)).get();
        Integer min = list.stream().min(Comparator.comparingInt(item -> item)).get();
        System.out.println("MAX：" + max + "   MIN：" + min);
    }

    /**
     * peek、foreach、map：的区别
     *
     * peek：主要用于Debug。
     *
     */
    public static void peekTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");

        List<String> peekResult = list.stream().peek(item -> {
            item = item + "asd";
            System.out.println("--->" + item);
        }).collect(Collectors.toList());
        System.out.println(peekResult);

        list.stream().forEach(item -> {
            item = item + "asd";
            System.out.println("--->" + item);
        });
        System.out.println(list == peekResult);
    }

    /**
     * skip：跳过index为0 到（n -1）元素。
     */
    public static void skipTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        list.add("EEE");
        list.add("FFF");
        list.add("CCC");

        List<String> skipResult = list.stream().skip(2L).collect(Collectors.toList());
        System.out.println(skipResult);
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static
    class StreamObject {

        private String username;

    }
}
