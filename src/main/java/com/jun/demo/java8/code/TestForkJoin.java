package com.jun.demo.java8.code;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author Jun
 * @date: 19-10-26 上午11:49
 */
public class TestForkJoin {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(0, 100)
                .parallel()
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
