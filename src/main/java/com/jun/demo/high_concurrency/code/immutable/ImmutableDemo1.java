package com.jun.demo.high_concurrency.code.immutable;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author Jun
 * @date: 19-10-30 下午5:37
 */
public class ImmutableDemo1 {
    private final static Integer number = 10;
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1 , 2);
        map.put(3 , 4);
        map.put(5 , 6);
    }

    public static void main(String[] args) {
    }
}
