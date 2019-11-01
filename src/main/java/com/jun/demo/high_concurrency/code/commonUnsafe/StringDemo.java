package com.jun.demo.high_concurrency.code.commonUnsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 字符串拼接不安全写法
 *
 * @author Jun
 * @date: 19-10-31 下午4:08
 */
public class StringDemo {
    private static final int THREAD_TOTAL = 200;
    private static final int CLIENT_TOTAL = 5000;
    //    private static StringBuffer stringBuffer = new StringBuffer();
    private static StringBuilder stringBuffer = new StringBuilder();

    private static volatile int count = 0;

    private static CountDownLatch countDownLatch = new CountDownLatch(CLIENT_TOTAL);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < CLIENT_TOTAL; i++) {
            pool.execute(() -> {
                update();
                countDownLatch.countDown();
                System.out.println(++count);
            });
        }
        countDownLatch.await();
        pool.shutdown();
        System.out.println("size - " + stringBuffer.length());
        System.out.println("Over");
    }


    private static void update() {
        stringBuffer.append("i");
    }

}