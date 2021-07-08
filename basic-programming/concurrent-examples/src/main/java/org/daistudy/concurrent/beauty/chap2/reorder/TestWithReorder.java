package org.daistudy.concurrent.beauty.chap2.reorder;

import org.daistudy.concurrent.beauty.util.DateTimeUtil;

public class TestWithReorder {
    private volatile static boolean ready = false;
    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread read = new Thread(() -> {
            System.out.println(DateTimeUtil.time() + " -- begin read");
            while(!Thread.currentThread().isInterrupted()){
                if (ready) {
                    System.out.println(DateTimeUtil.time() + " -- " + num);
                }else{
                    System.out.println(DateTimeUtil.time() + " -- " + num);
                }
            }
            System.out.println(DateTimeUtil.time() + " -- end read");
        }, "read");

        Thread write = new Thread(() -> {
            System.out.println(DateTimeUtil.time() + " -- begin write");
            num = 2;
            ready = true;
            System.out.println(DateTimeUtil.time() + " -- end write");
        }, "write");

        read.start();
        write.start();

        Thread.sleep(45);
        read.interrupt();

        System.out.println(DateTimeUtil.time() + " -- " + "main thread over");
    }
}
