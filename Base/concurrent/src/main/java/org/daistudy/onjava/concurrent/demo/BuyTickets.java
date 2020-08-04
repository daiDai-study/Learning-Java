package org.daistudy.onjava.concurrent.demo;

public class BuyTickets implements Runnable {
    private int ticketNum = 10;

    @Override
    public void run() {
        while (true){
            if(ticketNum <= 0){
                break;
            }
            try {
                // 延时模拟
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNum-- + "张票");
        }
    }

    public static void main(String[] args) {
        BuyTickets buy = new BuyTickets();
        new Thread(buy, "小王").start();
        new Thread(buy, "小李").start();
        new Thread(buy, "黄牛").start();
        new Thread(buy, "小红").start();
    }
}
