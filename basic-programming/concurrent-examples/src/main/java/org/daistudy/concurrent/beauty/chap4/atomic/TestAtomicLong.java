package org.daistudy.concurrent.beauty.chap4.atomic;

import java.util.concurrent.atomic.AtomicLong;

public class TestAtomicLong {
    private static AtomicLong countWithAtomic = new AtomicLong();

    private static long count = 0L;

    private static volatile long countWithVolatile = 0L;

    private static int[] array = new int[1000];

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < array.length; i++) {
                int x = array[i];
                if (x == 0) {
                    countWithAtomic.incrementAndGet();
                    count++;
                    countWithVolatile++;
                }
            }
        };
        Thread one = new Thread(task, "one");
        Thread two = new Thread(task, "two");
        Thread three = new Thread(task, "three");
        Thread four = new Thread(task, "four");

        one.start();
        two.start();
        three.start();
        four.start();

        one.join();
        two.join();
        three.join();
        four.join();

        System.out.println("countWithAtomic of zero: " + countWithAtomic.get());
        System.out.println("count of zero: " + count);
        System.out.println("countWithVolatile of zero: " + countWithVolatile);

        System.out.println("main thread over");
    }
}
