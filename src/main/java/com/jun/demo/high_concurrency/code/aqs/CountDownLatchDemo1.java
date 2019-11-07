package com.jun.demo.high_concurrency.code.aqs;


import org.junit.platform.commons.logging.LoggerFactory;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * @author Jun
 * @date: 19-11-1 下午3:24
 */
public class CountDownLatchDemo1 {
    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    private static int threadCount = 200;
    private static int clientCount = 5000;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < clientCount; i++) {
            final int threadNum = i;
            pool.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    outLogger(e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        pool.shutdown();
        outLogger("The programming execute over");
    }

    private static void test(int testNum) throws InterruptedException {
        outLogger(testNum);
        Thread.sleep(100);
    }

    private static void outLogger(Object o) {
//        System.out.println(Instant.now().atZone(ZoneId.systemDefault()) + "");
        System.out.println(o +"  -  "+ new Date(System.currentTimeMillis()).toInstant());
    }
}
