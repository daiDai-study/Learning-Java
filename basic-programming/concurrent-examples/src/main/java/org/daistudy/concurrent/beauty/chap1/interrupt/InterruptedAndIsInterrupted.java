package org.daistudy.concurrent.beauty.chap1.interrupt;

/**
 * isInterrupted是实例方法，并且不会清除中断标记
 * interrupted是静态方法，查询是调用线程的中断状态，并且会清除中断标记
 */
public class InterruptedAndIsInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (; ; ) {

            }
        });

        thread.start();

        thread.interrupt();

        System.out.println("thread.isInterrupted(): " + thread.isInterrupted());
        System.out.println("thread.interrupted(): " + thread.interrupted());
        System.out.println("Thread.interrupted(): " + Thread.interrupted());
        System.out.println("thread.isInterrupted(): " + thread.isInterrupted());

        thread.join();

        System.out.println("main thread over");
    }
}
