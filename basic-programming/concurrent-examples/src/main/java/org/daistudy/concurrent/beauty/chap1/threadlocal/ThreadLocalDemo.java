package org.daistudy.concurrent.beauty.chap1.threadlocal;

public class ThreadLocalDemo {

    private static ThreadLocal<String> local = new ThreadLocal<>();
    private static ThreadLocal<String> local2 = new ThreadLocal<>();

    public static void main(String[] args) {
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " -- before set: " + local.get());
            local.set("a");
            System.out.println(name + " -- after set and before remove: " + local.get());
            local.remove();
            System.out.println(name + " -- after remove: " + local.get());

            System.out.println(name + " -- before set: " + local2.get());
            local2.set("a2");
            System.out.println(name + " -- after set and before remove: " + local2.get());
            local2.remove();
            System.out.println(name + " -- after remove: " + local2.get());
        };

        new Thread(task, "threadA").start();
        new Thread(task, "threadB").start();
    }
}
