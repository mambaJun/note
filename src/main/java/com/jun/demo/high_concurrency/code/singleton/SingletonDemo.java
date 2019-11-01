package com.jun.demo.high_concurrency.code.singleton;

/**
 * @author Jun
 * @date: 19-10-30 下午3:44
 */
public class SingletonDemo {
    private SingletonDemo() {
    }

    // 懒汉式
    private static SingletonDemo instance = null;

    public synchronized static SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }
}
