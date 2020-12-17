package com.liu.study.reflect.model;

import com.liu.study.reflect.annotation.MethodAnnotation;
import com.liu.study.reflect.annotation.ParameterAnnotation;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/12/17 13:17
 */
public class SuperStudent {

    @MethodAnnotation("this is totalStudentAge")
    public int totalStudentAge(@ParameterAnnotation("this is parameter of totalStudentAge method") String username) {
        System.out.println("统计学生年龄");
        return 10;
    }

}
