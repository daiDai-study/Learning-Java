package org.daistudy.onjava.concurrent.state;

public class TestPriority implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());

        TestPriority testPriority = new TestPriority();

        Thread t1 = new Thread(testPriority);
        Thread t2 = new Thread(testPriority);
        Thread t3 = new Thread(testPriority);
        Thread t4 = new Thread(testPriority);
        Thread t5 = new Thread(testPriority);
        Thread t6 = new Thread(testPriority);

        t1.start();

        t2.setPriority(4);
        t2.start();

        t3.setPriority(2);
        t3.start();

        t4.setPriority(10);
        t4.start();

        t5.setPriority(8);
        t5.start();

        t6.setPriority(9);
        t6.start();
    }

}
