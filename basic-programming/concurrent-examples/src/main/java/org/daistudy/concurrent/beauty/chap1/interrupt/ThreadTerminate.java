package org.daistudy.concurrent.beauty.chap1.interrupt;

import org.daistudy.concurrent.beauty.util.DateTimeUtil;

public class ThreadTerminate {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println(DateTimeUtil.time() + " -- " + Thread.currentThread() + " hello");
            }
        };
        Thread thread = new Thread(task);

        // 启动子线程
        thread.start();

        // 主线程睡眠 1 s
        Thread.sleep(1000);

        // 主线程中中断子线程
        System.out.println(DateTimeUtil.time() + " -- " + "main thread interrupt thread");
        thread.interrupt();

        // 等待子线程结束
        thread.join();
        System.out.println(DateTimeUtil.time() + " -- " + "main thread over");
    }
}
