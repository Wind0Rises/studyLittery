package com.liu.study.littery.util;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/10/26 12:56
 */
public class SpliteratorStudy<T> {

    private final Object[] elements;

    public SpliteratorStudy(T[] data, Object[] tags) {
        int size = data.length;
        if (tags.length != size) {
            throw new IllegalArgumentException();
        }
        this.elements = new Object[2 * size];
        for (int i = 0, j = 0; i < size; ++i) {
            elements[j++] = data[i];
            elements[j++] = tags[i];
        }
    }

    /**
     * tryAdvance()：单独遍历。
     * forEachRemaining()：批量顺序遍历。
     * trySplit()：进行分区。
     *
     * @param
     * @return
     * @author: lwa
     */
    public static void main(String[] args) {
        String arr = "12%3 21sdas s34d dfsdz45 R3 jo34 sjkf8 3$1P 213ikflsd fdg55 kfd";
        Stream<Character> stream = IntStream.range(0, arr.length()).mapToObj(arr::charAt);
        stream.forEach(System.out::println);

        System.out.println("==================================================");
        // 传入true表示是并行流
        Spliterator<Character> spliterator = new SpliteratorImpl(0, arr,true);
        Stream<Character> parallelStream = StreamSupport.stream(spliterator, true);
        parallelStream.forEach(System.out::println);
    }

    static class SpliteratorImpl implements Spliterator<Character> {

        private String str;

        private int currentChar = 0;

        private boolean canSplit = true;

        SpliteratorImpl(int currentChar, String str, boolean canSplit) {
            this.str = str;
            this.currentChar = currentChar;
            this.canSplit = canSplit;
        }


        @Override
        public boolean tryAdvance(Consumer<? super Character> action) {
            if (str.equals("")) {
                return false;
            }
            action.accept(str.charAt(currentChar++));
            return currentChar < str.length();
        }

        @Override
        public Spliterator<Character> trySplit() {
            int i = currentChar;

            //第一个不是数字的pos，进行分割
            for (; canSplit && i < str.length(); ++i) {
                if (!Character.isDigit(str.charAt(i))) {
                    String str1 = str;
                    this.str = str1.substring(currentChar, i);
                    canSplit = false;
                    if (i + 1 < str1.length()) {
                        return new SpliteratorImpl(0, str1.substring(i + 1, str1.length()), true);
                    } else {
                        return null;
                    }
                }
            }
            canSplit = false;
            return null;
        }

        @Override
        public long estimateSize() {
            return str.length() - currentChar;
        }

        @Override
        public int characteristics() {
            return ORDERED | SIZED | SUBSIZED | NONNULL | IMMUTABLE;
        }
    }

}