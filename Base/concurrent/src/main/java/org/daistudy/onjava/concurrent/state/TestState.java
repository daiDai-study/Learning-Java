package org.daistudy.onjava.concurrent.state;

public class TestState implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "运行开始");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void main(String[] args) throws InterruptedException {
        TestState showState = new TestState();
        Thread thread = new Thread(showState);
        System.out.println("new state = " + thread.getState());

        thread.start();
        System.out.println("running state = " + thread.getState());

        while(thread.getState() != Thread.State.TERMINATED){
            Thread.sleep(100);
            System.out.println("thread state = " + thread.getState());
        }
    }
}
