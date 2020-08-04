package org.daistudy.onjava.concurrent.syncronized.unsafe;

import java.util.ArrayList;
import java.util.List;

public class UnsafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    list.add(Thread.currentThread().getName() + ":" + j);
                }
            }).start();
        }

//        for (int i = 0; i < 10000; i++) {
//            new Thread(()->{
//                list.add(Thread.currentThread().getName());
//            }).start();
//        }

        int activeCount;
        while((activeCount = Thread.activeCount()) > 2){
            System.out.println("活跃线程数量：" + activeCount + "---------" + "列表元素数量：" + list.size());
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("活跃线程数量：" + activeCount + "---------" + "列表元素数量：" + list.size());
    }
}
