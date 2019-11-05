package com.jun.demo.high_concurrency.code.atomic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author Jun
 * @date: 19-10-28 上午11:35
 */
public class AtomicLong {
    private static int threadTotal = 200;
    private static int clientTotal = 5000;

    public static Long count = 0L;

    public static LongAdder longAdder = new LongAdder();

    @Test
    public void testAtomicLong() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            pool.submit(() -> {
                count++;
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println(count);
    }
}
