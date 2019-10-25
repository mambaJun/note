package com.jun.demo.juc.code;

/**
 * @author Jun
 * @date: 19-10-25 上午9:06
 */
public class TestVolatile {
    volatile boolean flag = false;

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo).start();

        while (true) {
            if (threadDemo.isFlag()) {
                System.out.println("######################");
                break;
            }
        }
    }
}

class ThreadDemo implements Runnable {
//    private volatile boolean flag = false;
    private  boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
            flag = true;
            System.out.println(Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}