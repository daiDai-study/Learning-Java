package org.daistudy.concurrent.beauty.chap1.join;

public class JoinInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " begin run!");
            for (; ; ) {
            }
        }, "threadA");

        Thread mainThread = Thread.currentThread();

        Thread threadB = new Thread(() -> {
            // 1s后中断主线程
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " begin interrupt mainThread!");
            mainThread.interrupt();
        }, "threadB");

        threadA.start();
        threadB.start();

        threadA.join(); // 由于 join 内部调用了 wait(0) 方法，会阻塞调用线程，如果阻塞期间中断调用线程会报出 中断异常
    }
}
