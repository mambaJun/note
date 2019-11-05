package com.jun.demo.high_concurrency.code.concurrent;

import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author Jun
 * @date: 19-11-1 上午11:26
 */
public class CopyOnWriteArrayListDemo {
    public static int clientTotal = 5000;
    public static int threadTotal = 200;

    private  static Integer count = 1;

    private static Set<Integer> list = new CopyOnWriteArraySet<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            pool.execute(() -> {
                add(count++);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        pool.shutdown();
        System.out.println("--- > " + list.size());
    }

    private synchronized static void add(Integer integer) {
        if (integer.equals(5000)) {
            System.out.println("########################################################3");
        }
        System.out.println(integer);
        list.add(integer);
    }


}
