package com.liu.study.littery.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/10/22 13:20
 */
public class StreamTheoryTest {

    public static void main(String[] args) {
        firstMethod();
    }

    /**
     * StreamSupport：用于创建和操作Stream的底层类。
     *      1、<T> Stream<T> stream(Spliterator<T> spliterator, boolean parallel)
     *      2、<T> Stream<T> stream(Supplier<? extends Spliterator<T>> supplier, int characteristics, boolean parallel)
     *      3、IntStream intStream(Spliterator.OfInt spliterator, boolean parallel)
     *      4、IntStream intStream(Supplier<? extends Spliterator.OfInt> supplier, int characteristics, boolean parallel)
     *      5、LongStream longStream(Spliterator.OfLong spliterator, boolean parallel)
     *      ... long/double
     *
     * Spliterator：
     *
     */
    public static void firstMethod() {
        Stream<String> liu = Stream.of("liu", "wei", "an");
    }

}