package org.daistudy.concurrent.beauty.chap6.locksupport;

import java.util.concurrent.locks.LockSupport;

public class UnparkPark {
    public static void main(String[] args) throws InterruptedException {
        Thread child = new Thread(() -> {
            System.out.println("child thread begin park");
            // 调用 park 方法，挂起自己
            LockSupport.park();
            System.out.println("child thread end park");
        });

        // 启动子线程
        child.start();
        // 主线程睡眠1s
        Thread.sleep(2000);
        // 调用 unpack 方法让 child 线程持有许可证，使其在 park 方法处返回
        System.out.println("main thread begin unpark!");
        LockSupport.unpark(child);
    }
}
