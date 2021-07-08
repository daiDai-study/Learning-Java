package org.daistudy.concurrent.beauty.chap1.join;

public class JoinTime {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread threadA = new Thread(runnable);
        Thread threadB = new Thread(runnable);
        Thread threadC = new Thread(runnable);
        Thread threadD = new Thread(runnable);
        Thread threadD1 = new Thread(runnable);
        Thread threadD2 = new Thread(runnable);
        Thread threadD3 = new Thread(runnable);
        Thread threadD4 = new Thread(runnable);
        Thread threadD5 = new Thread(runnable);
        Thread threadD6 = new Thread(runnable);
        Thread threadD7 = new Thread(runnable);
        Thread threadD8 = new Thread(runnable);

        long t0 = System.currentTimeMillis();

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadD1.start();
        threadD2.start();
        threadD3.start();
        threadD4.start();
        threadD5.start();
        threadD6.start();
        threadD7.start();
        threadD8.start();

        threadA.join(); // threadA.join 会调用 threadA.wait(0) 方法阻塞主线程
        threadB.join();
        threadC.join();
        threadD.join();
        threadD1.join();
        threadD2.join();
        threadD3.join();
        threadD4.join();
        threadD5.join();
        threadD6.join();
        threadD7.join();
        threadD8.join();

        long t1 = System.currentTimeMillis();

        System.out.println("单个任务执行时间约为 1000 ms" );
        System.out.println("多线程并发执行时间： " + (t1 - t0) + " ms");
    }
}
