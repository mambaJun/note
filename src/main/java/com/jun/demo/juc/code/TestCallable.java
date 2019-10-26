package com.jun.demo.juc.code;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * @author Jun
 * @date: 19-10-25 下午1:35
 */
public class TestCallable {
    public static void main(String[] args) {
        ThreadCallableDemo threadCallableDemo = new ThreadCallableDemo();
        // 执行 Callable 方式，需要FutureTask 实现类的支持，用于接收运算结果
        FutureTask<Integer> result = new FutureTask<>(threadCallableDemo);
        new Thread(result).start();

        try {
            // FutureTask 可以用于 闭锁
            Integer sum = result.get();
            System.out.println(sum);
            System.out.println("-----------------------------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class ThreadCallableDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
            System.out.println(i);
        }
        return sum;
    }
}


