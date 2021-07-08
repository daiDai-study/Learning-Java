package org.daistudy.concurrent.beauty.chap1.interrupt;

import org.daistudy.concurrent.beauty.util.DateTimeUtil;

public class InterruptSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            try {
                System.out.println(DateTimeUtil.time() + " -- " + name + " is in sleep");
                Thread.sleep(5000);
                System.out.println(DateTimeUtil.time() + " -- " + name + " is in awaked");
            } catch (InterruptedException e) {
                System.out.println(DateTimeUtil.time() + " -- " + name + " is interrupted while sleep");
                return;
            }finally {
                System.out.println(DateTimeUtil.time() + " -- " + name + " finally");
            }
            System.out.println(DateTimeUtil.time() + " -- " + name + " leaving normally");
        };

        Thread thread = new Thread(task, "threadA");

        thread.start();

        Thread.sleep(1000);

        thread.interrupt();

        thread.join();

        System.out.println(DateTimeUtil.time() + " -- " + " main thread over");
    }
}
