package org.daistudy.onjava.concurrent.syncronized.juc;

import java.util.concurrent.CopyOnWriteArrayList;

public class TestList {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> list.add(Thread.currentThread().getName())).start();
        }
        Thread.sleep(3000);
        System.out.println("list 持有元素数量：" + list.size());
    }
}
