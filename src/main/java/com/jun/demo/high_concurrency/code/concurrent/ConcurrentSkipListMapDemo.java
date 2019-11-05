package com.jun.demo.high_concurrency.code.concurrent;

import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Jun
 * @date: 19-11-1 下午2:43
 */
public class ConcurrentSkipListMapDemo {

    private static Integer clientTotal = 5000;
    private static Integer threadTotal = 200;

    private static ConcurrentSkipListMap<Integer, Integer> map = new ConcurrentSkipListMap<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            pool.execute(() -> {
                put(100);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        pool.shutdown();
        System.out.println("map.size() - " + map.size());
    }

    private static void put(Integer integer) {
        map.put(integer, integer);
    }
}
