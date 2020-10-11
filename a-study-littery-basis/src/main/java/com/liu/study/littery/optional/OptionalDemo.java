package com.liu.study.littery.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @desc
 * @author Liuweian
 * @createTime 2020/9/3 22:57
 * @version 1.0.0
 */
public class OptionalDemo {

    public static void main(String[] args) {
        Student student = new Student();
        student.setUsername("liu");
        Optional<String> username = Optional.ofNullable(student.getUsername());
        System.out.println(username);


        Student.Course course = Student.Course.builder().courseAge(23).clazz("we").build();
        student.setCourses(new ArrayList<Student.Course>() {{ add(course); }});
        Optional<List<Student.Course>> courses = Optional.ofNullable(student.getCourses());
        System.out.println(courses);

        System.out.println(Optional.ofNullable(student.getPassword()));

        /**
         * 如果Optional中的value满足给定的predicate，返回包含value的Optional，
         * 否者返回一个空的Optional
         */
        System.out.println("---------------------------------------------------------");
        student.setPassword("liuwe");
        Optional<String> s = Optional.ofNullable(student.getPassword()).filter(item -> {
            /**
             * 这个item是Option的value值。
             */
            if ("liuwe".equals(item)) {
                return true;
            }
            return false;
        });
        System.out.println(s.get());
    }

}
