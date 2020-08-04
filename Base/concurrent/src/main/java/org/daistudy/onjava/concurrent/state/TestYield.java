package org.daistudy.onjava.concurrent.state;

public class TestYield {
    private static class Yield implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "运行开始");
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
    }

    public static void main(String[] args) {
        Yield yield = new Yield();
        new Thread(yield, "A").start();
        new Thread(yield, "B").start();
    }
}


