package org.daistudy.concurrent.beauty.chap1.yield;

import org.daistudy.concurrent.beauty.util.DateTimeUtil;

/**
 * yield 会暗示调度器让出自己的 CPU 的执行权，并处于就绪状态
 */
public class YieldTest {
    public static void main(String[] args) {
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(DateTimeUtil.time() + " -- " + name + " is in yield");
            Thread.yield();
            System.out.println(DateTimeUtil.time() + " -- " + name + " is end");
        };
        Thread threadA = new Thread(task, "threadA");
        Thread threadB = new Thread(task, "threadB");
        Thread threadC = new Thread(task, "threadC");
        threadA.start();
        threadB.start();
        threadC.start();
    }


}