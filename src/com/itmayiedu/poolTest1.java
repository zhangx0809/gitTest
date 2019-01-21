package com.itmayiedu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class poolTest1 {
    public static void main(String[] args) {
        //创建一个可重用固定线程数的线程池
//        ExecutorService pool = Executors.newFixedThreadPool(3);
//        ExecutorService pool = Executors.newSingleThreadExecutor();
//        ExecutorService pool = Executors.newCachedThreadPool();
        //创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        //创建实现了 Runnable 接口对象，Thread 对象当然也实现了 Runnable 接口
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        //使用定时执行风格的方法
        pool.schedule(t4, 2, TimeUnit.SECONDS); //t4 和 t5 在 10 秒后执行
        pool.schedule(t5, 4, TimeUnit.SECONDS);
        //关闭线程池
        pool.shutdown();
    }
}
    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "正在执行。。。");
        }
    }

