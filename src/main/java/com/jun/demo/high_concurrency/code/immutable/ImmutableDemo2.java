package com.jun.demo.high_concurrency.code.immutable;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author Jun
 * @date: 19-10-30 下午5:37
 */
public class ImmutableDemo2 {
    private final static Integer number = 10;
    private final static Map<Integer, Integer> map = ImmutableMap.<Integer, Integer>builder()
            .put(1, 2)
            .put(1, 2)
            .put(1, 2)
            .build();

    public static void main(String[] args) {
    }
}
