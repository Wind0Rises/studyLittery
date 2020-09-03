package com.liu.study.littery;

import java.util.Optional;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/8/15 15:57
 * @version 1.0.0
 */
public class OptionalTest {

    public static void main(String[] args) {

        /**
         * 获取Optional
         */
        Optional<Student> optionalFirst = Optional.empty();
        Optional<Student> optionalSecond = Optional.of(new Student());
    }

}
