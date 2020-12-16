package com.liu.study.reflect.model;

import com.liu.study.reflect.annotation.CustomChildStudentAnnotation;
import lombok.Data;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/12/15 14:04
 */
@Data
@CustomChildStudentAnnotation(value = "this is CustomChildStudentAnnotation Annotation of ChildFirstStudent")

public class ChildFirstStudent extends Student {

    private String first;

}
