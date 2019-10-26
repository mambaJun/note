package com.jun.demo.juc.code;

/**
 * 题目：判断打印的 one or two
 * 1、两个普通同步方法，两个线程，标准打印         one Two
 * 2、新增Thread.sleep() 给 getOne            one Two
 * 3、新增普通方法getThree()                   one Two
 * 4、两个普通同步方法，两个Number 对象           tow one
 * 5、修改getOne() 为静态同步方法，一个Number对象 one tow
 * 6、修改两个方法均为静态同步方法，一个Number 方法 one two
 * 7、一个静态方法，一个非静态方法，两个Number对象  Two one
 * 8、两个静态同步方法，两个Number对象            one Two
 * <p>
 * 线程八锁：
 * 1、费静态方法的锁默认为 this，静态方法的锁为 对应的Class 实例
 * 2、某一时刻内，只能有一个线程持有锁，无论 几个方法
 *
 * @author Jun
 * @date: 19-10-26 上午10:10
 */
public class TestThread8Monitor {
    public static void main(String[] args) {
        Number number = new Number();
        new Thread(() -> number.getOne()).start();
        System.out.println("---------------------------------------");
        new Thread(() -> number.getTwo()).start();
        new Thread(() -> number.getThree()).start();

    }
}

class Number {
    public synchronized void getOne() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("One");
    }

    public synchronized void getTwo() {
        System.out.println("Two");
    }

    public synchronized void getThree() {
        System.out.println("Three");
    }
}
