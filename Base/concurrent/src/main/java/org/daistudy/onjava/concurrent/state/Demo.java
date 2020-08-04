package org.daistudy.onjava.concurrent.state;

public class Demo implements Runnable{
    @Override
    public void run() {
        System.out.println("run state = " + Thread.currentThread().getState());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Demo());
        System.out.println("new state = " + thread.getState());
        thread.start();
        System.out.println("start state = " + thread.getState());
        Thread.sleep(100);
        System.out.println("thread state = " + thread.getState());
    }
}
