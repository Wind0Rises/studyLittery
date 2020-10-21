package com.liu.study.littery.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Function测试。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/14 16:44
 */
public class FunctionTest {

    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        ReturnObject returnObject = test.functionMethod((item) -> {
            return new FunctionTest().new ReturnObject(item);
        }, "liuweian");
        System.out.println(returnObject.getName());

        System.out.println("-----------------------------------------------");
        ArrayList<String> lists = new ArrayList<String>() {{
            add("liuweian");
            add("zhangsna");
        }};

        List<String> li = lists.stream().map((item) -> {
            System.out.println(item);
            return "li";
        }).collect(Collectors.toList());
        System.out.println(li);

    }

    /**
     *
     * @param convert
     * @param username
     * @return
     */
    public ReturnObject functionMethod(Function<String, ReturnObject> convert, String username) {
        return convert.apply(username);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    class ReturnObject{

        private String name;

    }

}