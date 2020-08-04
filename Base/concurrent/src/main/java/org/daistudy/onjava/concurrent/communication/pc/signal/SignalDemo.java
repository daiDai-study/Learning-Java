package org.daistudy.onjava.concurrent.communication.pc.signal;

public class SignalDemo {
    private static volatile int signal = 0;
    private static String lock = "lock";

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (signal < 5){
                if(signal%2 == 0){
                    System.out.println(Thread.currentThread().getName() + "-->" +signal);
                    synchronized (lock){
                        signal++;
                    }
                }
            }
        }).start();
        Thread.sleep(100);
        new Thread(() -> {
            while (signal < 5){
                if(signal%2 == 1){
                    System.out.println(Thread.currentThread().getName() + "-->" +signal);
                    synchronized (lock){
                        signal++;
                    }
                }
            }
        }).start();
    }
}
