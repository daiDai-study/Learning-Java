package org.daistudy.onjava.concurrent.demo;

public class ExtendsThread extends Thread {
    @Override
    public void run() {
        System.out.println("thread start");
        System.out.println("thread name: " + Thread.currentThread().getName());
        System.out.println("thread group name: " + Thread.currentThread().getThreadGroup().getName());
        System.out.println("thread end");
    }

    public static void main(String[] args) {
        System.out.println("main start");
        Thread thread = new ExtendsThread();
        thread.start();
        // 注意不可多次调用start()方法。在第一次调用start()方法后，再次调用start()方法会抛出异常。
        // thread.start();
        System.out.println("main end");
    }
}
