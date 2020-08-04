package org.daistudy.onjava.concurrent.state;

public class BlockedTest {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(BlockedTest::test);
        Thread b = new Thread(BlockedTest::test);
        a.start();
        a.join();
        b.start();
//        Thread.sleep(1000);
        System.out.println(a.getName() + ":" + a.getState());
        System.out.println(b.getName() + ":" + b.getState());
    }

    private static synchronized void test(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
