package org.daistudy.onjava.concurrent.lock.reentrant;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class conditionobject {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                String name = Thread.currentThread().getName();
                System.out.println(name + "begin await");
                condition.await();
                System.out.println(name + "end await");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            lock.lock();
            try {
                String name = Thread.currentThread().getName();
                System.out.println(name + "begin signal");
                condition.signal();
                System.out.println(name + "end signal");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();
    }
}
