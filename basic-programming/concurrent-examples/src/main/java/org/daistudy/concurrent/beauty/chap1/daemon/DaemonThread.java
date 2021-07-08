package org.daistudy.concurrent.beauty.chap1.daemon;

/**
 * 线程分为守护线程和用户线程
 * JVM 进程需要等待非守护（daemon）线程全部执行完毕才会结束，不会理会守护线程是否执行完毕
 *
 * main 线程是一个用户线程；
 * main 线程运行结束后， JVM 会自动启动一个叫做 DestroyJavaVM 的线程，该线程会等待所有用户线程结束后终止 JVM 进程
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (; ; ) {

            }
        });

        thread.setDaemon(true);
        thread.start();

        System.out.println("main thread over");
    }
}
