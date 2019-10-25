package com.jun.demo.juc.code;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jun
 * @date: 19-10-25 上午11:02
 */
public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int i = 0; i < 20; i++) {
            new Thread(atomicDemo).start();
        }
    }
}

class AtomicDemo implements Runnable {
//    private volatile int serialNumber = 0;
    private AtomicInteger serialNumber = new AtomicInteger();

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.print(getSerialNumber() + " ");
        System.out.println(Thread.currentThread().getName() + " : " + getSerialNumber());
    }

    public int getSerialNumber() {
        return serialNumber.getAndIncrement();
    }

//    public int getSerialNumber() {
//        return serialNumber++;
//    }
}
