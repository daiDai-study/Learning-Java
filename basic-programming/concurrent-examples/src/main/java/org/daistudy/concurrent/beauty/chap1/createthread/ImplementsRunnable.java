package org.daistudy.concurrent.beauty.chap1.createthread;

public class ImplementsRunnable implements Runnable {

    private String name;

    public ImplementsRunnable(String name){
        this.name = name;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(name + threadName + " start");
        System.out.println(name + threadName + " end");
    }

    public static void main(String[] args) {
        System.out.println("main start");
        ImplementsRunnable target = new ImplementsRunnable("123: ");
        new Thread(target).start();
        new Thread(target).start();
        System.out.println("main end");
    }
}
