package com.liu.study.littery.collection.lang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/17 15:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassObject<T> extends ClassSuper implements Runnable {

    private ClassObject(String username) {

    }

    private T t;

    public String username;

    public  Runnable runnable = new Runnable() {
        @Override
        public void run() {

        }
    };

    private void privateMethod() {

    }

    public final void finalMethod() {

    }

    public String getString() {
        return "liuweian";
    }

    @Override
    public void run() {

    }

    class Liu {

    }
}