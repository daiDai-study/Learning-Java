package org.daistudy.concurrent.beauty.chap1.sleep;

import org.daistudy.concurrent.beauty.util.DateTimeUtil;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * sleep(time) 会使得当前调用线程在指定时间内不参与 CPU 的调度，但不会释放已经占用的监视器资源（如锁）
 */
public class SleepNotReleaseLock {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable task = () -> {
            lock.lock();
            try {
                String name = Thread.currentThread().getName();
                System.out.println(DateTimeUtil.time() + " -- " + name + " is in sleep");
                Thread.sleep(5000);
                System.out.println(DateTimeUtil.time() + " -- " + name + " is in awaked");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        };
        Thread threadA = new Thread(task, "threadA");
        Thread threadB = new Thread(task, "threadB");
        threadA.start();
        threadB.start();
    }


}