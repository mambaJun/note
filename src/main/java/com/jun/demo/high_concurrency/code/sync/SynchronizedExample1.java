package com.jun.demo.high_concurrency.code.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Jun
 * @date: 19-10-28 下午2:08
 */
public class SynchronizedExample1 {
    // 修饰代码块：大括号括起来的代码，作用于调用的对象
    public void test1(int num) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.printf("test1 - %d -" + i, num);
                System.out.println();
            }
        }
    }

    // 修饰方法：整个方法，作用于调用的对象
    public synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            System.out.println("test2 - " + i);
            }
    }

    // 修饰静态方法：整个静态方法，作用于所有对象
    public synchronized static void test3() {

    }

    // 修饰类：括号括起来的部分，作用于所有对象
    public void test4() {

    }

    public static void main(String[] args) {
        SynchronizedExample1 example = new SynchronizedExample1();
        SynchronizedExample1 example1 = new SynchronizedExample1();
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(() -> example.test1(1));
        pool.submit(() -> example1.test1(2));
    }
}
