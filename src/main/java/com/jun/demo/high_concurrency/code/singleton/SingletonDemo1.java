package com.jun.demo.high_concurrency.code.singleton;

/**
 * @author Jun
 * @date: 19-10-30 下午3:44
 */
public class SingletonDemo1 {
    private SingletonDemo1() {
    }

    // 懒汉式
    private static SingletonDemo1 instance = null;

    // 1. memory = allocate() 分配对象的空间
    // 2.ctorInstance() 初始化对象
    // 3.instance = memory 设置instance指向刚分配的内存

    // JVM 和 CPU指令重排的出现导致 不安全
    public synchronized static SingletonDemo1 getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo1.class) {
                if (instance == null) {
                    instance = new SingletonDemo1();
                }
            }
        }
        return instance;
    }
}
