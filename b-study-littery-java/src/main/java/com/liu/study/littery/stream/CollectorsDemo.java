package com.liu.study.littery.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
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
     *
     *  <note>
     *      所有带concurrent都是进行并行操作的，并行操作就要放弃顺序性。
     * </note>
     */
    public static void main(String[] args) {
        // 01、基础方法。
        // basisMethod();

        // 02、常用方法。
        // collectorsApi();

        /**
         * 03、joining()方法；和guava的Joiner很类似。
         */
        // testJoining();

        /**
         *
         */
         // testGroupingBy();

        /**
         * reduce：归纳；
         *      reducing(
         *          T identity,                 // 最后返回的对象，有且只有一个，遍历每个元素都是这个元素都是不变的。
         *          BinaryOperator<T> op        // BinaryOperator的第一个参数就是T，第二个参数，就是每次遍历的元素。
         *     )
         */
         testReducing();

        /**
         *
         */
        // testCounting();

        /**
         * 分类：只能分为两类，一个是true、一个是false。
         */
        // testPartitioningBy();


        /**
         *
         */
        // testMapping();

    }

    public static void basisMethod() {
        ArrayList<Integer> collect = Stream.of("1", "2", "3", "4", "3").collect(() -> {
            ArrayList<Integer> createCollection = new ArrayList<>();
            System.out.println("第一步创建的集合：" + createCollection.hashCode());
            return createCollection;
        }, (first, item) -> {
            System.out.println("第二步传入的：" + first.hashCode());
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
         * 1. Supplier生产者：返回最终结果
         * 2. BiConsumer<R, ? super T> accumulator 累加器，第一个参数是要返回的集合, 第二个参数是遍历过程中的每个元素,
         *    将流中每个被遍历的元素添加到集合中
         * 3. BiConsumer<R, R> combiner 合并器, 在有并行流的时候才会有用, 一个流时代码不会走到这里 将第二步遍历得到的
         *    所有流形成的list都添加到最终的list中, 最后返回list1
         */
        System.out.println("\n\n\n");
        System.out.println("========================================    详解   ==========================================");
        Stream<String> stream = Stream.of("hello", "world", "helloworld");
        List<String> listDetail = stream.collect(
                () -> {
                    ArrayList<String> arrayList = new ArrayList<>();
                    System.out.println("第一步list诞生, size: " + arrayList.size());
                    return arrayList;
                },
                (theList, item) -> {
                    theList.add(item);
                    System.out.println("第二步把元素添加到第一步产生的结果中：" +  theList);
                },
                (list1, list2) -> {
                    System.out.println("第三步，不会进入");
                }
        );
        System.out.println(listDetail);


        System.out.println("\n\n\n");
        System.out.println("=====================================    PARALLEL      ===========================================");
        Map<String, List<String>> collect2 = Stream.of("1", "2", "3", "4").collect(() -> {
            Map<String, List<String>> firstStepCollection = new HashMap<>(10);
            return firstStepCollection;
        }, (firstStepCollection, item) -> {
            if (Integer.valueOf(item) > 2) {
                List<String> da = Optional.ofNullable(firstStepCollection.get("da")).orElse(new ArrayList<>());
                da.add(item);
                firstStepCollection.put("da", da);
            } else {
                List<String> xiao = Optional.ofNullable(firstStepCollection.get("xiao")).orElse(new ArrayList<>());
                xiao.add(item);
                firstStepCollection.put("xiao", xiao);
            }
        }, (firstCollection, secondCollection) -> {
            System.out.println("------  这里不会被执行 ------");
        });
        System.out.println(collect2);


        System.out.println("\n\n\n");
        System.out.println("=====================================    PARALLEL      ===========================================");
        /**
         * 第一步：创建Collection。
         * 第二步：把Stream中的数据，添加到第一步创建的Collection中。
         * 第三步：只用使用了parallel()时，才会调用，操作两个集合。
         */
        ArrayList<Integer> collect3 = Stream.of("1", "2", "3", "4", "5", "6").parallel().collect(() -> {
            ArrayList<Integer> strings = new ArrayList<>();
            return strings;
        }, (first, item) -> {
            first.add(Integer.valueOf(item));
            System.out.println("---------  " + item);
        }, (list1, list2) -> {
            System.out.println("list1：" + list1 + " ; list2：" + list2);
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

        /**
         * 统计元素出现的次数。
         */
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("2");
        list.add("2");
        list.add("3");

        Map<String, Long> frequency = list.stream().collect(Collectors.groupingBy(item -> item, Collectors.counting()));
        System.out.println(frequency);
    }


    /**
     * Collectors.joining()方法：
     */
    public static void testJoining() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("2");
        list.add("2");
        list.add("3");

        String joiningResult = list.stream().collect(Collectors.joining());
        System.out.println(joiningResult);

        String joiningResult1 = list.stream().collect(Collectors.joining("--"));
        System.out.println(joiningResult1);

        /**
         * 在整个拼接完成后的字符串前后添加前缀和后缀。
         */
        String joiningResult2 = list.stream().collect(Collectors.joining("--", "Prefix", "Suffix"));
        System.out.println(joiningResult2);
    }


    /**
     *
     */
    public static void testGroupingBy() {
        List<TestData> list = new ArrayList<>();
        TestData data1 = TestData.builder().name("L").total(1).build();
        TestData data2 = TestData.builder().name("I").total(2).build();
        TestData data3 = TestData.builder().name("N").total(3).build();
        TestData data4 = TestData.builder().name("L").total(4).build();
        TestData data5 = TestData.builder().name("L").total(5).build();
        TestData data6 = TestData.builder().name("N").total(6).build();
        list.add(data1);
        list.add(data2);
        list.add(data3);
        list.add(data4);
        list.add(data5);
        list.add(data6);

        /**
         * 根据item -> item.getName()的值进行分支，应该是equal()进行比较的。
         */
        Map<String, List<TestData>> collect = list.stream().collect(Collectors.groupingBy(item -> item.getName()));
        System.out.println(collect);


        /**
         * groupingBy(
         *              Function<? super T, ? extends K> classifier,    // 通过操作对象，获取对应的分组条件，就是根据什么进行分支。
         *              Supplier<M> mapFactory,                         // groupingBy()方法执行完成以后，返回的对象，如果只是简单的分组，一般返回Map<Object, List<Object>>
         *              Collector<? super T, A, D> downstream           // 每组保存的数据类型。Map<Object, List<Object>>对应这List<Object>。也就是对分类的数据进行相应的操作。
         * )
         */
        HashMap<String, List<TestData>> li = list.stream().collect(Collectors.groupingBy(TestData::getName, HashMap::new, Collectors.toList()));
        System.out.println(li);
    }

    /**
     *
     */
    public static void testReducing() {
        List<TestData> list = new ArrayList<>();
        TestData data1 = TestData.builder().name("L").total(1).build();
        TestData data2 = TestData.builder().name("I").total(2).build();
        TestData data3 = TestData.builder().name("N").total(3).build();
        TestData data4 = TestData.builder().name("L").total(4).build();
        TestData data5 = TestData.builder().name("L").total(5).build();
        TestData data6 = TestData.builder().name("N").total(6).build();
        list.add(data1);
        list.add(data2);
        list.add(data3);
        list.add(data4);
        list.add(data5);
        list.add(data6);

        /**
         * reduce[/rɪˈdjuːs/ ]：减少；缩小；归纳为
         * first；就是new TestDataReducing(null, 0)，<note>first对象一直是那一个</note>
         * second：就是
         */
        Object collect = list.stream().collect(Collectors.reducing(new TestDataReducing(null, 0), (first, second) -> {
            System.out.println("first：" + first.hashCode() + ",  second：" + second.hashCode());
            System.out.println("first对象：" + first + ",,,,second：" + second);
            return first;
        }));
        System.out.println("#########################################");
        System.out.println(collect.hashCode());
        System.out.println("#########################################");
    }

    /**
     * Collectors的Counting()方法。
     */
    public static void testCounting() {
        List<TestData> list = new ArrayList<>();
        TestData data1 = TestData.builder().name("L").total(1).build();
        TestData data2 = TestData.builder().name("I").total(2).build();
        TestData data3 = TestData.builder().name("N").total(3).build();
        TestData data4 = TestData.builder().name("L").total(4).build();
        TestData data5 = TestData.builder().name("L").total(5).build();
        TestData data6 = TestData.builder().name("N").total(6).build();
        list.add(data1);
        list.add(data2);
        list.add(data3);
        list.add(data4);
        list.add(data5);
        list.add(data6);

        Long collect = list.stream().collect(Collectors.counting());
        System.out.println(collect);

        Map<String, Long> collect1 = list.stream().collect(Collectors.groupingBy(TestData::getName, Collectors.counting()));
        System.out.println(collect1);
    }

    /**
     * 分类。
     * 只能分为两类；Predicate的返回值：true or false。
     */
    public static void testPartitioningBy() {
        List<String> list = Arrays.asList("1", "2", "3", "4", "3", "4");
        Map<Boolean, List<String>> collect = list.stream().collect(Collectors.partitioningBy(item -> item.equals("3")));
        System.out.println(collect);

        Map<Boolean, Set<String>> collect1 = list.stream().collect(Collectors.partitioningBy(item -> item.equals("3"), Collectors.toSet()));
        System.out.println(collect1);

        /**
         * groupingByConcurrent():进行并行处理。
         * 这是一个并发、无需的
         */
        Map<Boolean, Set<String>> collect2 = list.stream().collect(Collectors.groupingByConcurrent(item -> item.equals("3"), Collectors.toSet()));
        System.out.println(collect2);
    }

    /**
     * 和Stream.map()类似。返回一个新的对象，并收集。
     */
    public static void testMapping() {
        List<String> list = Arrays.asList("1", "2", "3", "4", "3", "4");
        List<String> collect = list.stream().collect(Collectors.mapping(item -> item + "2222", Collectors.toList()));
        System.out.println(collect);
    }

    /**
     * Function
     *
     * Supplier
     *
     * Consumer
     *
     * Predicate
     *
     */



    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class TestData {

        private String name;

        private Integer total;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class TestDataReducing {

        private String groupBy;

        private Integer average;
    }
}