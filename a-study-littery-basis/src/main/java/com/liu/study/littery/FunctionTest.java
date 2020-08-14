package com.liu.study.littery;

import lombok.Data;

import java.util.function.Function;

/**
 * Function测试。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/14 16:44
 */
public class FunctionTest {

    public static void main(String[] args) {

    }

    /**
     *
     * @param convert
     * @param username
     * @return
     */
    public ReturnObject test(Function<String, ReturnObject> convert, String username) {
        return convert.apply(username);
    }

    @Data
    class ReturnObject{

        private String name;

    }

}