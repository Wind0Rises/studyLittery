package com.liu.study.littery.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Consumer;

/**
 * Consumer：
 *
 * @author Liuweian
 * @createTime 2020/8/15 12:19
 * @version 1.0.0
 */
public class ConsumerTest {

    public static void main(String[] args) {
        new ConsumerTest().testMethod((item) -> {
            System.out.println(item);
        }, "zhangsan");
    }

    public void testMethod(Consumer<String> consumer, String username) {
        consumer.accept(username);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class DataObject {

        private String username;

    }

}
