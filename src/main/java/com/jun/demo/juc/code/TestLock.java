package com.jun.demo.juc.code;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jun
 * @date: 19-10-25 下午3:31
 */
public class TestLock {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket,"1号窗口").start();
        new Thread(ticket,"2号窗口").start();
        new Thread(ticket,"3号窗口").start();
    }
}

class Ticket implements Runnable {
    private int tick = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (tick > 0) {
                    Thread.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "完成售票，余票为： " + --tick);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
