package com.liu.study.littery.util;

import java.util.Iterator;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/10/26 13:25
 */
public class IteratorStudy {

    public static void main(String[] args) {

    }

    class IteratorTest implements Iterator {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }

}