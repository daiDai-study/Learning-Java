package org.daistudy.onjava.concurrent.demo;

public class LambdaRunnable {
    public static void main(String[] args) {
        System.out.println("main start");
        new Thread(() -> {
            System.out.println("thread start");
            System.out.println(LambdaRunnable.class.getName());
            System.out.println("thread end");
        }).start();
        System.out.println("main end");
    }
}
