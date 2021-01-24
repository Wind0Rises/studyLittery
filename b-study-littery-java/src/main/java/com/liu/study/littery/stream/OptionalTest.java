package com.liu.study.littery.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * Optional学习Demo
 *
 * @author Liuweian
 * @createTime 2020/8/15 15:57
 * @version 1.0.0
 */
public class OptionalTest {

    /**
     * Optional：该类是被final修饰的；内部有一个private final T value参数，就是Optional对象包装的值。
     */
    public static void main(String[] args) {
        /**
         * 创建Optional对象。
         */
        // createOptional();

        /**
         *
         */
        getMethodTest();
    }

    /**
     * 创建Optional对象。
     */
    public static void createOptional() {
        /**
         * 创建一个空的Optional对象。
         */
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        Optional<OperatorData> hasValueOptional = Optional.of(new OperatorData("liuweina"));
        System.out.println(hasValueOptional);

        Optional<OperatorData> ofNullable = Optional.ofNullable(null);
        System.out.println(ofNullable);

        /**
         * of()方法：参数不能为空。
         */
        Optional<Object> o = Optional.of(null);
    }

    /**
     * isPresent()：判断Optional内部的value是否为null。
     * ifPresent()：如果Optional内部的value，执行Consumer操作。
     * orElse(T t)：获取Optional内部的value，如果value为null的话，返回传入的t。
     * orElseGet(Suppler suppler)：获取Optional内部的value，如果value为null的话，执行suppler并返回。
     * orElseThrow(Suppler suppler)：获取Optional内部的value，如果value为null的话，执行suppler并抛出异常。
     * map(Function function)：Optional内部的value为null直接返回，否则执行function，并返回。
     * filter(Predicate predicate)：Optional内部的value为null直接返回，否则执行Predicate，并返回。
     */
    public static void getMethodTest() {
        /**
         * 非空
         */
        Optional<OperatorData> hasValueOptional = Optional.of(new OperatorData("liuweina"));
        System.out.println("【非空】对象—get" + hasValueOptional.get());
        System.out.println("【非空】对象—isPresent：" + hasValueOptional.isPresent());
        hasValueOptional.ifPresent(item -> {
            System.out.println("-------- 非 空 ---------");
        });


        System.out.println("++++++++++++++++++++++++++++++++++++++");

        /**
         * 空
         */
        Optional<OperatorData> nullOperatorData = Optional.empty();
        System.out.println();
        // nullOperatorData.get()：会报No value present
        // System.out.println("【空】对象—get" + nullOperatorData.get());
        System.out.println("【空】对象—isPresent：" + nullOperatorData.isPresent());
        nullOperatorData.ifPresent(item -> {
            System.out.println("-------- 空 ---------");
        });
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    static class OperatorData {

        private String username;

    }

}
