package com.jun.demo.high_concurrency.code.atomic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jun
 * @date: 19-10-28 上午9:17
 */
public class AtomicXXXDemo {
    // 请求总数
    public static int clientTotal = 5000;
    // 同时并发执行的线程数
    public static int threadTotal = 200;
    public static int count = 0;

    @Test
    public void atomicTest() {
        AtomicInteger count = new AtomicInteger();
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < threadTotal; i++) {
            pool.submit(() -> {
                for (int j = 0; j < 500; j++) {
                    count.getAndIncrement();
                }
            });
        }
        pool.shutdown();
        System.out.println(count.get());
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < threadTotal; i++) {
            pool.submit(() -> {
                for (int j = 0; j < 500; j++) {
                    count++;
                }
            });
        }
        pool.shutdown();
        System.out.println(count);
    }
}
