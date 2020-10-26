package com.liu.study.littery.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/8/15 12:25
 * @version 1.0.0
 */
public class StreamTest {

    public static void main(String[] args) {
        Student.InnerClass innerClass = new Student.InnerClass();
        System.out.println(innerClass);

        firstTest();

        secondTest();
    }
    /**
     *
     */
    public static void firstTest() {
        Stream<String> stream3 = Stream.generate(() -> "love").limit(12);
        stream3.forEach(System.out::println);

        Stream<StreamObject> stream = Stream.of(new StreamObject[]{new StreamTest().new StreamObject("liu"),
                new StreamTest().new StreamObject("asdf")});

        stream.forEach(System.out::println);

        Stream.of("we").forEach(System.out::println);

        String[] tests = new String[]{"liuweian", "aesewesss"};

        List<String> collect = Stream.of(tests).flatMap(item -> Stream.of(item.split("")))
                .collect(Collectors.toList());

        System.out.println(collect);


        String reduce1 = Stream.of(tests).reduce("start:", (s, j) -> s.concat(j));
    }

    /**
     *
     */
    public static void secondTest() {
        /**
         * Stream底层是使用StreamSupport进行实现的：
         */
        Stream.of(Arrays.asList("li", "wei"));
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class StreamObject{
        private String username;

    }
}
