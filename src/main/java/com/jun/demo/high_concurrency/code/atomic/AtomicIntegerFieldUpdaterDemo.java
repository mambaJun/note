package com.jun.demo.high_concurrency.code.atomic;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author Jun
 * @date: 19-10-28 下午1:38
 */
public class AtomicIntegerFieldUpdaterDemo {
    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterDemo> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterDemo.class, "count");

    @Getter
    public volatile int count = 100;

    public AtomicIntegerFieldUpdaterDemo() {

    }

    public static void main(String[] args) {
        System.out.println(args);
    }

}
