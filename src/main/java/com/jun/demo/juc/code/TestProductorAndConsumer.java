package com.jun.demo.juc.code;

/**
 * 生产者 和 消费者
 *
 * @author Jun
 * @date: 19-10-25 下午4:08
 */
public class TestProductorAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);

        new Thread(productor,"生产者A").start();
        new Thread(consumer,"消费者B").start();
    }
}

// 店员
class Clerk {
    private int product = 0;

    // 进货
    public void get() {
        if (product >= 10) {
            System.out.println("产品已满");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        System.out.println(Thread.currentThread().getName() + " : " + ++product);
        this.notify();
    }

    // 卖货
    public void sale() {
        if (product <= 0) {
            System.out.println("缺货");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        System.out.println(Thread.currentThread().getName() + " : " + --product);
        this.notifyAll();
    }

}

// 生产者
class Productor implements Runnable {
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.get();
        }
    }
}

// 消费者
class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}
