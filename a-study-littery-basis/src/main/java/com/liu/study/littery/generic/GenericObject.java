package com.liu.study.littery.generic;

/**
 * 泛型的使用。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/24 17:45
 */
public class GenericObject<T> {

    /**
     *
     * 这不是一个泛型方法。
     *
     * @param t
     * @return
     */
    public T getMyself(T t) {
        T t1 = t;
        return t;
    }

}