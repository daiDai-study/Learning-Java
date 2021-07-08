package org.daistudy.concurrent.beauty.chap1.createthread;

public class ExtendsThread extends Thread {
    @Override
    public void run() {
        System.out.println("a child thread start");
        System.out.println("current thread name: " + this.getName());
        System.out.println("current thread group name: " + this.getThreadGroup().getName());
        System.out.println("a child thread end");
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
