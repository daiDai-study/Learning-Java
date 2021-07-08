package org.daistudy.concurrent.beauty.chap6.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestBoundedBuffer {

    static class BoundedBufferOfCondition {
        final Lock lock = new ReentrantLock();
        final Condition notFull = lock.newCondition();
        final Condition notEmpty = lock.newCondition();

        final Object[] items = new Object[2];
        int putptr, takeptr, count;

        public void put(Object x) throws InterruptedException {
            lock.lock();
            try {
                while (count == items.length)
                    notFull.await();
                items[putptr] = x;
                // putptr 标记下次放入的位置，此处，当下次放入的位置等于数组长度，将第一个位置作为下次放入的位置，数组将作为循环数组使用
                if (++putptr == items.length) putptr = 0;
                ++count;
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
        }

        public Object take() throws InterruptedException {
            lock.lock();
            try {
                while (count == 0)
                    notEmpty.await();
                Object x = items[takeptr];
                // takeptr 标记下次取出元素的位置，此处，当下次取出的位置等于数组长度，将第一个位置作为下次取出的位置，数组将作为循环数组使用
                if (++takeptr == items.length) takeptr = 0;
                --count;
                notFull.signal();
                return x;
            } finally {
                lock.unlock();
            }
        }
    }

    static class BoundedBufferOfSynchronized {
        final Object[] items = new Object[2];
        int putptr, takeptr, count;

        public synchronized void put(Object x) throws InterruptedException {
            while (count == items.length)
                this.wait();
            items[putptr] = x;
            // putptr 标记下次放入的位置，此处，当下次放入的位置等于数组长度，将第一个位置作为下次放入的位置，数组将作为循环数组使用
            if (++putptr == items.length) putptr = 0;
            ++count;
            this.notify();
        }

        public synchronized Object take() throws InterruptedException {
            while (count == 0)
                this.wait();
            Object x = items[takeptr];
            // takeptr 标记下次取出元素的位置，此处，当下次取出的位置等于数组长度，将第一个位置作为下次取出的位置，数组将作为循环数组使用
            if (++takeptr == items.length) takeptr = 0;
            --count;
            this.notify();
            return x;
        }
    }


    public static void main(String[] args) {
//        BoundedBufferOfCondition buffer = new BoundedBufferOfCondition();
        BoundedBufferOfSynchronized buffer = new BoundedBufferOfSynchronized();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    buffer.put(i);
                    System.out.println("put " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("take " + buffer.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
