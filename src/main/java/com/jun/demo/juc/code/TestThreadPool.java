package com.jun.demo.juc.code;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 一、线程池：提供一个线程队列，线程中保存着所有等待状态的线程，避免创建与销毁额外开销，提高了响应的速度
 * <p>
 * 二、线程池的体系结构
 * java.util.concurrent.Executor：负责线程的使用和调度
 * |--** ExecutorService 子接口：线程池的主要接口
 * |--ThreadPoolExecutor：线程池的实现类
 * |--ScheduleExecutorService：子接口：负责线程池的调度
 * |-- ScheduledThreadPoolExecutor：继承ThreadPoolExecutor，实现ScheduledExecutorService
 * 三、工具类：Executors
 * ExecutorService newFixedThreadPool() :创建固定大小的线程池
 * ExecutorService newCachedThreadPool() :缓存线程池，线程池的数量不固定，可以根据需求自动的更改数量
 * ExecutorService new SingleThreadExecutor() :创建单个线程池，线程池里只有一个线程
 * <p>
 * ScheduledExecutorService newScheduledThreadPool() :创建固定大小的线程，可以延迟定时或定时的执行任务
 *
 * @author Jun
 * @date: 19-10-26 上午10:29
 */
public class TestThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final int number = 5;
        // 创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(number);

        for (int i = 0; i < number * 10; i++) {
            // 给线程池分配任务
            Future<Integer> future = pool.submit(() -> {
                int sum = 0;
                for (int j = 0; j < 10; j++) {
                    sum += j;
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println("-------------------------------------------------");
                return sum;
            });
            System.out.println(future.get());
        }
        // 关闭线程池
        pool.shutdown();
    }
}