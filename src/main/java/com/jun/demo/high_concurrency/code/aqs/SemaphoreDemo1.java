package com.jun.demo.high_concurrency.code.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Jun
 * @date: 19-11-1 下午3:24
 */
public class SemaphoreDemo1 {
    private final static int threadTotal = 200;
    private final static int clientTotal = 5000;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(10);

        for (int i = 0; i < clientTotal; i++) {
            final int testNum = i;
            pool.execute(() -> {
                try {
                    semaphore.acquire();
                    test(testNum);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("###########################################################################################################################");
    }

    public static void test(int testNum) {
        System.out.println(testNum + "  --  " + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
