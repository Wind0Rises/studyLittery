package com.liu.study.reflect.second;

import com.liu.study.reflect.second.model.ChildFirstStudent;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Filed学习。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/1/18 9:43
 */
public class StudyField {

    public static void main(String[] args) {
        getClassField();
    }

    public static void getClassField() {
        /**
         *
         */
        Field[] declaredFields = ChildFirstStudent.class.getDeclaredFields();
        for (Field item : declaredFields) {
            System.out.println(item.getName());
        }

        /**
         *
         */
        Field[] fields = ChildFirstStudent.class.getFields();
        System.out.println("-------------------------------");
        Arrays.stream(fields).forEach(item -> {
            String name = item.getName();
            System.out.println(name);
        });
    }

}
