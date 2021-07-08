package org.daistudy.concurrent.beauty.chap6.reentrantrwlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 三个线程，分别为读写读，第一个线程获取到读锁，第二个线程进入同步队列，第三个线程能获取到读锁吗？
 *
 * 答案：第三个线程获取不到读锁，并进入到同步队列
 */
public class RWRTest {

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            readLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取到读锁");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放了读锁");
            }
        };
        Thread t1 = new Thread(task);

        Thread t2 = new Thread(() -> {
            writeLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取到写锁");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放了写锁");
            }
        });

        Thread t3 = new Thread(task);

        t1.start();
        Thread.sleep(500);
        t2.start();
        Thread.sleep(500);
        t3.start();
    }
}
