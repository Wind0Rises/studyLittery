package com.liu.study.reflect.second.model;

import com.liu.study.reflect.second.annotation.CustomAnnotationChildAnnotation;
import com.liu.study.reflect.second.annotation.CustomChildStudentAnnotation;
import lombok.Data;

/**
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/12/15 14:04
 */
@Data
@CustomChildStudentAnnotation
@CustomAnnotationChildAnnotation(value = "this is CustomAnnotationChildAnnotation of ChildFirstStudent")
public class ChildSecondStudent extends Student {

    private String second;

}
