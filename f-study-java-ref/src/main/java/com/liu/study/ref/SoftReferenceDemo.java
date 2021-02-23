package com.liu.study.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 软引用--学习
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/2/23 13:30
 */
public class SoftReferenceDemo {

    static class OOMClass {
        /**
         * 100KB
         */
        private int[] oom = new int[1024 * 100];
    }

    /**
     * -verbose:gc -Xms4m -Xmx4m -Xmn2m
     *
     * -verbose:gc：在控制台输出GC情况。
     * -XX:+PrintGCDetails：在控制台输出详细的GC情况
     * -Xloggc: filepath：将GC日志输出到指定文件中
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ReferenceQueue<OOMClass> queue = new ReferenceQueue<>();

        List<SoftReference> list = new ArrayList<>();

        while(true){
            for (int i = 0; i < 100; i++) {
                list.add(new SoftReference<OOMClass>(new OOMClass(), queue));
            }
            Thread.sleep(500);
        }
    }

}
