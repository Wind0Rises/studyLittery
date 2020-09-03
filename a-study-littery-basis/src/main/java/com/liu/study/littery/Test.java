package com.liu.study.littery;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/8/15 13:47
 * @version 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        new Test().test(() -> {
            return "liuwel";
        });

    }

    class Lid<T> implements Supplier<T> {

        @Override
        public T get() {
            return null;
        }
    }

    /**
     *
     * @param function
     */
    public void test(Supplier supplier) {
        System.out.println("######################");
        Object li = supplier.get();
        System.out.println("######################" + li);
    }

}
