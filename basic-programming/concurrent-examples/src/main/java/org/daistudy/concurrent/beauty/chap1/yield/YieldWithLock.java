package org.daistudy.concurrent.beauty.chap1.yield;

import org.daistudy.concurrent.beauty.util.DateTimeUtil;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * yield 相当于 sleep(0) 会使得当前调用线程立即让出 CPU 的执行，也跟 sleep() 一样不会释放已经占用的监视器资源（如锁）
 * 不同之处：
 * 1. yield 依赖于CPU的时间片划分；sleep()可以精确指定休眠的时间
 * 2. yield 不能中断，而且不会抛出中断异常；sleep() 可以
 */
public class YieldWithLock {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable task = () -> {
            lock.lock();
            try {
                String name = Thread.currentThread().getName();
                System.out.println(DateTimeUtil.time() + " -- " + name + " is in yield");
                Thread.yield();
                System.out.println(DateTimeUtil.time() + " -- " + name + " is end");

            } finally {
                lock.unlock();
            }
        };
        Thread threadA = new Thread(task, "threadA");
        Thread threadB = new Thread(task, "threadB");
        Thread threadC = new Thread(task, "threadC");
        threadA.start();
        threadB.start();
        threadC.start();
    }


}