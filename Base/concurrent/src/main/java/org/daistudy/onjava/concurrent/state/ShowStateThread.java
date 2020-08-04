package org.daistudy.onjava.concurrent.state;

public class ShowStateThread implements Runnable{
    private Thread thread;

    public ShowStateThread(Thread thread){
        this.thread = thread;
    }

    @Override
    public void run() {
        while(thread.getState() != Thread.State.TERMINATED){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getName() + ": " + thread.getState());
        }
    }
}
