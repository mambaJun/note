package com.jun.demo.high_concurrency.code.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Jun
 * @date: 19-10-28 下午1:55
 */
public class AtomicBooleanTest {

    private static AtomicBoolean isHappened = new AtomicBoolean();

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        System.out.println(isHappened.get());
        isHappened.compareAndSet(false, true);
        System.out.println(isHappened.get());
    }
}
