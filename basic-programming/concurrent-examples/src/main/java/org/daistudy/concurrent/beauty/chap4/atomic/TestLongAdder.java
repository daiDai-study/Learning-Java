package org.daistudy.concurrent.beauty.chap4.atomic;

import java.util.concurrent.atomic.LongAdder;

public class TestLongAdder {
    private static int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
    private static LongAdder count = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < array.length; i++) {
                count.add(array[i]);
            }
        };

        Thread one = new Thread(task, "one");
        Thread two = new Thread(task, "two");

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println("sum: " + count.sum());
    }
}
