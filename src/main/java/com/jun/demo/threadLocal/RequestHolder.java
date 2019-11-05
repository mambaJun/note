package com.jun.demo.threadLocal;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Vector;

/**
 * @author Jun
 * @date: 19-11-1 上午9:24
 */
public class RequestHolder {
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();
    private StringBuilder stringBuilder = new StringBuilder();
    private StringBuffer stringBuffer = new StringBuffer();

    static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMdd");

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i).equals(3)) {
                vector.remove(i);
            }
        }
        System.out.println(vector);
    }
}
