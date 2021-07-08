package org.daistudy.concurrent.beauty.chap1.createthread;

import java.util.concurrent.*;

public class ImplementsCallableWithPool implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("thread start");
        System.out.println(getClass().getName());
        Thread.sleep(2000);
        System.out.println("thread end");
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main start");

        // 开启执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 启动线程，并获取结果
        Future<String> submit = executorService.submit(new ImplementsCallableWithPool());

        // 得到结果
        String result = submit.get();

        // 关闭服务
        executorService.shutdownNow();

        System.out.println("result = " + result);

        System.out.println("main end");
    }
}
