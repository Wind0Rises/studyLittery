package com.liu.study.littery.generic;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/24 17:47
 */
public class GenericDemo {

    public <T> T showName(T t) {
        return t;
    }

    public static void main(String[] args) {
        GenericObject<String> genericObject = new GenericObject<>();
        String slei = genericObject.getMyself("slei");
        System.out.println(slei);

        String liwe = new GenericDemo().showName("liwe");
        System.out.println(liwe);
    }



}