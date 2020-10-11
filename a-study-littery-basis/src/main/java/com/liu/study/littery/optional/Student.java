package com.liu.study.littery.optional;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/9/3 22:58
 * @version 1.0.0
 */
@Data
public class Student {

    private String username;

    private String password;

    private List<Course> courses;

    @Data
    @Builder
    static class Course {
        private int courseAge;

        private String clazz;
    }

}
