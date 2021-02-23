package com.liu.study.littery.bitset.study;

import java.util.BitSet;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/10/19 21:53
 */
public class BitSetTest {

    public static void main(String[] args) {
        basisMethod();
    }


    public static void basisMethod() {
        BitSet bitSet = new BitSet();
        /**
         * 设置为true。62代表索引位置。
         */
        bitSet.set(62);
        System.out.println(bitSet.get(61));
        System.out.println(bitSet.get(62));
        System.out.println(bitSet.size());

        System.out.println("\n\n\n");
        System.out.println("==========================   分割线 1 ===============================");
        // 清理所有的索引
        bitSet.clear();
        System.out.println(bitSet);
        bitSet.set(62);
        bitSet.set(63);
        System.out.println(bitSet);
        bitSet.clear(62);
        System.out.println(bitSet);


        System.out.println("\n\n\n");
        System.out.println("==========================   分割线 2 ===============================");
        bitSet.set(62);
        BitSet andBitSet = new BitSet();
        andBitSet.set(62);
        andBitSet.set(59);
        System.out.println("and 开始前");
        System.out.println(bitSet);
        System.out.println(andBitSet);
        bitSet.and(andBitSet);
        System.out.println("and 结束后");
        System.out.println(bitSet);
        System.out.println(andBitSet); // andBitSet结果不变。
        // bitSet结果 = (bitSet & andBitSet)

        System.out.println("\n\n\n");
        System.out.println("==========================   分割线 3 ===============================");
        BitSet basisBitSet = new BitSet();
        basisBitSet.set(23);
        basisBitSet.set(24);
        basisBitSet.set(25);
        BitSet orBitSet = new BitSet();
        orBitSet.set(25);
        orBitSet.set(26);
        System.out.println("or 开始前");
        System.out.println(basisBitSet);
        System.out.println(orBitSet);
        basisBitSet.or(orBitSet);
        System.out.println("or 结束后");
        System.out.println(basisBitSet);
        System.out.println(orBitSet);   // orBitSet结果不变。
        // basisBitSet结果 = (bitSet | andBitSet)


        /**
         * 异或
         * 0 1 = 1
         * 1 0 = 1
         * 0 0 = 0
         * 1 1 = 0
         */
        System.out.println("\n\n\n");
        System.out.println("==========================   分割线 4 ===============================");
        BitSet basisBitSet1 = new BitSet();
        basisBitSet1.set(23);
        basisBitSet1.set(24);
        basisBitSet1.set(25);
        BitSet xor = new BitSet();
        xor.set(25);
        xor.set(26);
        System.out.println("xor 开始前");
        System.out.println(basisBitSet1);
        System.out.println(xor);
        basisBitSet1.xor(xor);
        System.out.println("xor 结束后");
        System.out.println(basisBitSet1);
        System.out.println(xor);

        System.out.println("\n\n\n");
        System.out.println("==========================   分割线 其他操作 ===============================");
        BitSet otherBitSet = new BitSet();
        otherBitSet.set(23);
        otherBitSet.set(24);
        System.out.println(otherBitSet); // 进行补码操作，对应一个bit位来说，就是取反
        otherBitSet.flip(23);
        otherBitSet.flip(25);
        System.out.println(otherBitSet);
    }

}