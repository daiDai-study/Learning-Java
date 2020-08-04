package org.daistudy.onjava.concurrent.state;

public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("thread: i = " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new TestJoin());
        Thread show = new Thread(new ShowStateThread(thread));
        show.start();
        Thread.sleep(100);
        thread.start();
        for (int i = 0; i < 200; i++) {
            System.out.println("main: i = " + i);
            if(i == 100){
                thread.join(1);
            }
        }
    }
}
