package org.daistudy.concurrent.beauty.chap1.sleep;

import org.daistudy.concurrent.beauty.util.DateTimeUtil;

public class SleepInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println(DateTimeUtil.time() + " -- " + name + " is in sleep");
                Thread.sleep(5000);
                System.out.println(DateTimeUtil.time() + " -- " + name + " is in awaked");
            } catch (InterruptedException e) {
                System.out.println(DateTimeUtil.time() + " -- exception: ");
                e.printStackTrace();
            }
        };

        Thread threadA = new Thread(task, "threadA");

        // 启动子线程
        threadA.start();

        // 主线程等待 2 s, 目的在于让子线程处于 sleep 中
        Thread.sleep(2000);

        // 主线程中断子线程
        threadA.interrupt();
    }
}
