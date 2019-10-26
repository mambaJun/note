package com.jun.demo.juc.code;

import java.time.Instant;
import java.util.concurrent.*;

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
 * @date: 19-10-26 上午11:11
 */
public class TestScheduledThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final int number = 5;
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(number);
        for (int j = 0; j < number; j++) {
            ScheduledFuture<Integer> schedule = pool.schedule(() -> {
                int sum = 0;
                int random = (int) (Math.random() * 1000);
                for (int i = 0; i < random; i++) {
                    sum += i;
                }
                return sum;
            }, 2000, TimeUnit.MILLISECONDS);
            System.out.println(schedule.get());
        }
        pool.shutdown();
    }
}
