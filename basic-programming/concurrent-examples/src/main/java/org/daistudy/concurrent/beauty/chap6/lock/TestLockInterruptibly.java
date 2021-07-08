package org.daistudy.concurrent.beauty.chap6.lock;

import org.daistudy.concurrent.beauty.util.DateTimeUtil;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLockInterruptibly {

    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(DateTimeUtil.time() + " -- " + name + " waiting get resource");
            try {
                lock1.lockInterruptibly();
                try {
                    System.out.println(DateTimeUtil.time() + " -- " + name + " get resource");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock1.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread1 = new Thread(task, "thread-1");
        Thread thread2 = new Thread(task, "thread-2");

        thread1.start();
        Thread.sleep(100);
        thread2.start();
        Thread.sleep(1000);
        thread2.interrupt();
    }

}
