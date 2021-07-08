package org.daistudy.concurrent.beauty.chap1.threadlocal;

/**
 * ThreadLocal 不支持继承性
 */
public class ThreadLocalUninheriable {
    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        local.set("main");
        new Thread(() -> {
            System.out.println("in child thread, before set local is : " + local.get());
            local.set("child");
            System.out.println("in child thread, after set local is : " + local.get());
        }).start();

        System.out.println("in main thread, local is : " + local.get());
    }
}
