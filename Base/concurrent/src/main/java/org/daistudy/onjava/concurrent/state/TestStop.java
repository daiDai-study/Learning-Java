package org.daistudy.onjava.concurrent.state;

public class TestStop implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println("running: i = " + i++);
        }
    }

    public void stop(){
        this.flag = false;
        System.out.println("start to end state = " + Thread.currentThread().getState());
    }

    public static void main(String[] args) throws InterruptedException {
        TestStop target = new TestStop();
        Thread thread = new Thread(target);
        System.out.println("new state = " + thread.getState());
        thread.start();
        System.out.println("start state = " + thread.getState());
        for (int i = 0; i < 2000; i++) {
            System.out.println("main: i = " + i);
            if(i == 600){
                target.stop();
            }
        }
        Thread.sleep(100);
        System.out.println("end state = " + thread.getState());
    }
}
