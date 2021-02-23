package com.liu.study.reflect.second.model;

import com.liu.study.reflect.second.annotation.CustomChildStudentAnnotation;
import lombok.Data;

import java.util.List;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/12/15 14:04
 */
@Data
@CustomChildStudentAnnotation(value = "this is CustomChildStudentAnnotation Annotation of ChildFirstStudent")
public class ChildFirstStudent extends Student {

    public String publicFiled;

    protected Integer protectedFiled;

    private List<String> privateList;

    private String first;

    public static void staticTest() {

    }

    public void overloadTest(String first) {

    }

    public void overloadTest(String first, Integer second) {

    }

    private void privateTest(String first) {

    }

}
