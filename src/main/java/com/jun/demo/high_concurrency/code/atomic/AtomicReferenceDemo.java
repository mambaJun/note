package com.jun.demo.high_concurrency.code.atomic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Jun
 * @date: 19-10-28 下午1:24
 */
public class AtomicReferenceDemo {
    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    @Test
    public void test() {
        count.compareAndSet(0, 2);
        count.compareAndSet(0, 1);
        count.compareAndSet(1, 2);
        count.compareAndSet(2, 4);
        count.compareAndSet(3, 5);

        System.out.println(count.get());
    }

}
