package com.jun.demo.juc.code;

import java.time.Instant;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch:闭锁，在完成某些运算时，只有其他所有线程的运算全部完成，当且运算才继续执行
 *
 * @author Jun
 * @date: 19-10-25 下午1:16
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        final int number = 5;
        // 初始化 锁的数量 number
        final CountDownLatch countDownLatch = new CountDownLatch(number);
        LatchDemo latchDemo = new LatchDemo(countDownLatch);

        long start = Instant.now().toEpochMilli();

        for (int i = 0; i < number; i++) {
            new Thread(latchDemo).start();
        }

        try {
            // 闭锁等待 线程完成后，执行
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = Instant.now().toEpochMilli();

        System.out.println("耗时间为：" + (end - start));
    }
}

class LatchDemo implements Runnable {
    private CountDownLatch countDownLatch;

    public LatchDemo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5000; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
            // 锁 减一
            countDownLatch.countDown();
        }
    }
}
