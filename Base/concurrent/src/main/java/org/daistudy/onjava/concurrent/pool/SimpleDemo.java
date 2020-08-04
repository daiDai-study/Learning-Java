package org.daistudy.onjava.concurrent.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDemo {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 线程池中丢入 runnable 实例（callable 实例）
        for (int i = 0; i < 50; i++) {
            executorService.execute(new RunTest(i + 1));
        }

        // 关闭线程池
        executorService.shutdown();
    }
}

class RunTest implements Runnable{
    private int id;

    public RunTest(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " --> id:" + id);
    }
}
