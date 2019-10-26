package com.jun.demo.juc.code;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Jun
 * @date: 19-10-25 下午5:32
 */
public class TestReadAndWriteLock {
    public static void main(String[] args) {
        ReadAndWriteLockDemo readAndWriteLockDemo = new ReadAndWriteLockDemo();

        new Thread(() -> readAndWriteLockDemo.set((int) (Math.random() * 100)), " - Write").start();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> readAndWriteLockDemo.get(), i + " - Read").start();
        }

    }
}

class ReadAndWriteLockDemo {
    private int number = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    // 读
    public void get() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " : " + number);
        } finally {
            lock.readLock().unlock();
        }
    }

    // 写
    public void set(int number) {
        lock.writeLock().lock();
        try {
            this.number = number;
            System.out.println(Thread.currentThread().getName() + "***************************************************写入");
        } finally {
            lock.writeLock().unlock();
        }
    }
}
