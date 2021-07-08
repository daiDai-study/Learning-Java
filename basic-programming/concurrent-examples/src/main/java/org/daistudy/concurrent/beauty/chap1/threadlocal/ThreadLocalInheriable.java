package org.daistudy.concurrent.beauty.chap1.threadlocal;

/**
 * InheritableThreadLocal 支持继承
 * 原理：在创建子线程时，如果父线程的 inheritableThreadLocals 不为 null，
 * 会将父线程中 inheritableThreadLocals 中的键值对复制一份到子线程中
 */
public class ThreadLocalInheriable {
    private static InheritableThreadLocal<String> local = new InheritableThreadLocal<>();

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
