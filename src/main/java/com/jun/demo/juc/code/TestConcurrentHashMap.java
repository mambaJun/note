package com.jun.demo.juc.code;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jun
 * @date: 19-10-25 上午11:39
 */
public class TestConcurrentHashMap {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("str", "ABC");
        String str = map.get("str");
        System.out.println(str);
    }
}
