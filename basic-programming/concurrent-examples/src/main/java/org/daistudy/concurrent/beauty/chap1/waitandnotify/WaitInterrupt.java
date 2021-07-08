package org.daistudy.concurrent.beauty.chap1.waitandnotify;

public class WaitInterrupt {
    private static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("begin");
                synchronized (obj) {
                    obj.wait();
                }
                System.out.println("end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();

        Thread.sleep(1000);

        System.out.println("begin interrupt child thread");
        thread.interrupt();
        System.out.println("end interrupt child thread");
    }
}
