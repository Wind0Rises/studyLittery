package com.liu.study.littery.collection;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayBlockingQueue学习Demo。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/12/23 13:03
 */
public class ArrayBlockingQueueDemo {

    private static final ArrayBlockingQueue<String> emptyQueue = new ArrayBlockingQueue<String>(10);

    private static final ArrayBlockingQueue<String> fullQueue = new ArrayBlockingQueue<String>(2){{add("liu"); add("an");}};

    private static final ArrayBlockingQueue<String> testQueue = new ArrayBlockingQueue<String>(10){{add("zhang"); add("san");}};


    public static void main(String[] args) {
        /**
         * 添加元素。
         */
        addElementToQueue();

        /**
         * 获取但是不删除元素。
         */
        // getNotDeleteElement();

        /**
         * 获取并删除元素。
         */
        // getAndDeleteElement();
    }

    /**
     * 向队列中添加元素。
     * <note>
     *     add：向满队列添加元素，直接报错。
     *     offer：返回一个boolean值，成功就返回true，失败就返回false。
     *     put：向一个满队列中添加元素，会堵塞直到队列中有空位置。
     * </note>
     */
    private static void addElementToQueue() {
        /**
         * add()：添加操作，如果队列中已经满了，在向队列中添加元素，就会报错。
         */
        testQueue.add("12");
        System.out.println(testQueue);
        try {
            fullQueue.add("12");
        } catch (Exception e) {
            System.err.println("add向一个满队列：" + e);
        }
        System.out.println();

        System.out.println("=================   offer   =================");
        boolean offer = testQueue.offer("offer");
        System.out.println("向有空间的队列中添加元素（offer）：" + offer + "    testQueue ==>" + testQueue);
        boolean fullOffer = fullQueue.offer("full-queue");
        System.out.println("向没空间的队列中添加元素（fullQueue offer）:" + fullOffer+ "    testQueue ==>" + testQueue);

        System.out.println();
        System.out.println("=================   put   =================");
        try {
            testQueue.put("put");
            System.out.println("向有空间的队列中put元素：【成功】" + "     testQueue ==>" + testQueue);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            // fullQueue.put("put");
            System.out.println("如果队列满了，会一直卡住，直到队列中有空间。");
        } catch (Exception e) {
            System.err.println("向没有空间的队列中put元素：" + e.getMessage());
        }
    }

    /**
     * 获取并不删除元素。
     *
     * <note>
     *     peek：对空队列直接返回null。
     *     element：对空队列直接报错：NoSuchElementException
     * </note>
     *
     */
    public static void getNotDeleteElement() {
        System.out.println("peek前数据：" + testQueue);
        String peek = testQueue.peek();
        System.out.println("peek获取的数据：" + peek + "     peek后的数据：" + testQueue);
        String peek1 = emptyQueue.peek();
        System.out.println("peek一个空的队列：" + peek1);
        System.out.println();

        System.out.println("================  element  ==================");
        System.out.println("element前队列数据：" + testQueue);
        String element = testQueue.element();
        System.out.println("element的数据：" + element + "     element后队列的数据：" + testQueue);
        try {
            String element1 = emptyQueue.element();
        } catch (Exception e) {
            System.err.println("对空队列进行element操作报错，错误信息：" + e);
        }
    }

    /**
     * 获取并删除元素。
     * <note>
     *     remove：对空队列会报错。
     *     take：对于空队列会一直等待，直到有元素或者InterruptedException
     *     poll：如果是一个空队列，直接返回null。
     * </note>
     */
    public static void getAndDeleteElement() {
        System.out.println("remove操作前的数据：" + testQueue);
        String remove = testQueue.remove();
        System.out.println("remove的数据：" + remove + "       队列信息 => " + testQueue);
        try {
            String remove1 = emptyQueue.remove();
        } catch (Exception e) {
            System.err.println("对空的队列进行remove操作报错，错误信息为：" + e);
        }

        System.out.println();
        System.out.println("================  take  ==================");
        try {
            String take = testQueue.take();
            System.out.println(take);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            String take = emptyQueue.take();
            System.out.println("================ 【不会执行这句话】 ==================");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void arrayBlockingQueueOtherMethod() {
        // testQueue.drainTo()
        // testQueue.removeIf()
        // testQueue.containsAll()
    }

}
