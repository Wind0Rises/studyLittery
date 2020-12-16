package com.liu.study.reflect.model;

import com.liu.study.reflect.annotation.CustomAnnotation;
import lombok.Data;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/12/15 13:55
 */
@Data
@CustomAnnotation(value = "this is CustomAnnotation Annotation of Student")
public class Student {

    private String username;

    private int age;

    private String like;

    @CustomAnnotation(value = "this is CustomAnnotation Annotation of Student#queryUserName")
    public void queryUserName() {
        System.out.println("查询Username");
    }

    public int totalStudentAge(String username) {
        System.out.println("统计学生年龄");
        return 10;
    }

    protected String getStudentLike(String username, int age) {
        return "爱好";
    }

    private String groupByAge() {
        return "分类";
    }
}
