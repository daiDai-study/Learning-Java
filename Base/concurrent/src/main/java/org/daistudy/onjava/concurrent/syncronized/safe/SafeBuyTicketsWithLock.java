package org.daistudy.onjava.concurrent.syncronized.safe;

import java.util.concurrent.locks.ReentrantLock;

public class SafeBuyTicketsWithLock {
    private static class BuyTicket implements Runnable{
        private final ReentrantLock lock = new ReentrantLock();

        // 线程终止标志
        private boolean flag = true;

        // 票数
        private int ticketNum = 10;

        // 买票
        private void buy(){
            lock.lock();
            try{
                if(ticketNum <= 0){
                    flag = false;
                    return;
                }
                // 延时模拟
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "买到了第" + ticketNum-- + "张票");
            }finally {
                lock.unlock();
            }

        }

        @Override
        public void run() {
            while(flag){
                buy();
            }
        }
    }

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "你").start();
        new Thread(buyTicket, "我").start();
        new Thread(buyTicket, "他").start();
    }
}
