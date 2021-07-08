package org.daistudy.concurrent.beauty.chap1.deadlock;

import org.daistudy.concurrent.beauty.util.DateTimeUtil;

/**
 * 死锁产生的四个必要条件：
 * 1. 资源的独占性 -- 互斥条件：资源在任何时刻只能由一个线程占有，不能同时由一个以上的线程占有
 * 2. 资源的不可剥夺条件：资源在持有线程持有期间不能被其他线程抢占，只有当持有线程使用完毕后由持有线程释放
 * 3. 持有并请求条件：线程在持有一个资源的同时，请求另一个资源
 * 4. 环路等待条件 -- 循环等待：线程和资源之间形成了一个环形链
 *
 * 避免死锁：破环上述四个必要条件之一即可
 *
 * 避免死锁的常用方法：
 * 保证资源申请的有序性：破坏了持有并请求条件和环路等待条件
 */
public class ClassicDeadLock {
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(DateTimeUtil.time() + " -- " + name + " waiting get resourceA");
            synchronized (resourceA){
                System.out.println(DateTimeUtil.time() + " -- " + name + " get resourceA");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(DateTimeUtil.time() + " -- " + name + " waiting get resourceB");
                synchronized (resourceB){
                    System.out.println(DateTimeUtil.time() + " -- " + name + " get resourceB");
                }
            }
        }).start();

        new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(DateTimeUtil.time() + " -- " + name + " waiting get resourceB");
            synchronized (resourceB){
                System.out.println(DateTimeUtil.time() + " -- " + name + " get resourceB");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(DateTimeUtil.time() + " -- " + name + " waiting get resourceA");
                synchronized (resourceA){
                    System.out.println(DateTimeUtil.time() + " -- " + name + " get resourceA");
                }
            }
        }).start();
    }
}
