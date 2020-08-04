package org.daistudy.onjava.concurrent.demo;

public class ImplementsRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("thread start");
        System.out.println(getClass().getName());
        System.out.println("thread end");
    }

    public static void main(String[] args) {
        System.out.println("main start");
        Thread thread = new Thread(new ImplementsRunnable());
        thread.start();
        System.out.println("main end");
    }
}
